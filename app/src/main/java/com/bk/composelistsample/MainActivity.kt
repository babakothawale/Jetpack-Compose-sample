package com.bk.composelistsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.bk.composelistsample.ui.basiclist.ListScreenContent
import com.bk.composelistsample.ui.theme.ComposeListSampleTheme

/**
 * In 01 we created Very basic-vanilla example of list in Compose.
 * In 02 we saw sending event from UI- User Action
 * 03- Now we are updating the UI according to state
 * Again this does not include AppBar component
 *
 * We have 3 state, loading, empty, and with items.
 * Also we are updating item list by deleting item from list using User Event - Delete action
 *
 * To test empty state, change in [ListViewModel.generateData]
 *
 */
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ComposeListSampleTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          val viewModel: ListViewModel by viewModels()
          val uiState by viewModel.uiState.collectAsState()
          ListScreenContent(
            uiState = uiState,
            onItemClick = { name -> viewModel.onItemClick(name) },
            onDeleteClick = { name -> viewModel.onDeleteClick(name) }
          )
        }
      }
    }
  }
}