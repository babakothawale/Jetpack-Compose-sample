package com.bk.composelistsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.bk.composelistsample.ui.basiclist.ListScreen
import com.bk.composelistsample.ui.theme.ComposeListSampleTheme

/**
 * Very basic-vanilla example of list in Compose. This does not include even AppBar component
 */
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ComposeListSampleTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          ListScreen(List(50) { i -> "$i" })
        }
      }
    }
  }
}