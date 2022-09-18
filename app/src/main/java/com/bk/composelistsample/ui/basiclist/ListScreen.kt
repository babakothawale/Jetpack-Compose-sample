package com.bk.composelistsample.ui.basiclist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.bk.composelistsample.R
import com.bk.composelistsample.UiState
import com.bk.composelistsample.components.CompList
import com.bk.composelistsample.ui.theme.ComposeListSampleTheme

@Preview(showBackground = true)
@Composable
fun ListScreenPreview() {
  ComposeListSampleTheme {
    ListScreen(UiState.Items(false, "", List(2) { i -> "$i" }), {}, {})
  }
}

@Preview(showBackground = true)
@Composable
fun ListScreenEmptyPreview() {
  ComposeListSampleTheme {
    EmptyListScreen()
  }
}

@Preview(showBackground = true)
@Composable
fun FullScreenLoadingPreview() {
  ComposeListSampleTheme {
    FullScreenLoading()
  }
}

/**
 * This sample is to just to get the understanding
 * and start unlearning the existing ways of coding
 * and start thinking in Compose way.
 * This is not the complete code to use in production
 */
@Composable
fun ListScreen(
  uiState: UiState,
  onItemClick: (String) -> Unit,
  onDeleteClick: (String) -> Unit,
  modifier: Modifier = Modifier
) {
  val items = when (uiState) {
    is UiState.Items -> uiState.list
    is UiState.EmptyState -> arrayListOf()
  }
  CompList(
    listItems = items,
    onItemClick = onItemClick,
    onDeleteClick = onDeleteClick,
    modifier = modifier
  )
}

/**
 * Check the different state from UIState and create only the Composable
 * required to show on UI
 */
@Composable
fun LoadingScreenContent(
  isEmpty: Boolean,
  isLoading: Boolean,
  emptyContent: @Composable () -> Unit,
  content: @Composable () -> Unit
) {
  if (isLoading) {
    FullScreenLoading()
  } else if (isEmpty) {
    emptyContent()
  } else {
    content()
  }
}

/**
 * Empty message
 */
@Composable
fun EmptyListScreen() {
  Row(
    modifier = Modifier
      .fillMaxSize()
      .wrapContentSize(Alignment.Center)
  ) {
    Text(
      text = stringResource(id = R.string.empty_list),
      color = MaterialTheme.colorScheme.onSurface
    )
  }
}

/**
 * Full screen circular progress indicator
 */
@Composable
fun FullScreenLoading() {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .wrapContentSize(Alignment.Center)
  ) {
    CircularProgressIndicator()
  }
}