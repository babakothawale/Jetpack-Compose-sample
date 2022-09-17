package com.bk.composelistsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.bk.composelistsample.ui.basiclist.ListScreen
import com.bk.composelistsample.ui.theme.ComposeListSampleTheme

/**
 * Moving head from Very basic-vanilla example of list in Compose.
 * Again this does not include AppBar component
 * We have introduced basic ViewModel and UIState to generate list items
 * Also we call the ViewModel method when list item is clicked - i.e sending User Action-Event
 */
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ComposeListSampleTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          val viewModel = ListViewModel()
          val uiState by viewModel.uiState.collectAsState()
          ListScreen(uiState, { name -> viewModel.onItemClick(name) })
        }
      }
    }
  }
}