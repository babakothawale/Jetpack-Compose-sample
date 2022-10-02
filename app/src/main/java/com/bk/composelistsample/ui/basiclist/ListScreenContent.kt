package com.bk.composelistsample.ui.basiclist

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bk.composelistsample.UiState
import com.bk.composelistsample.ui.theme.ComposeListSampleTheme

@Preview(showBackground = true)
@Composable
fun ListScreenContentPreview() {
  ComposeListSampleTheme {
    ListScreenContent(UiState.Items(false, "", List(2) { i -> "$i" }), {}, {})
  }
}


@Composable
fun ListScreenContent(
  uiState: UiState,
  onItemClick: (String) -> Unit,
  onDeleteClick: (String) -> Unit,
  modifier : Modifier = Modifier,
) {
  LoadingScreenContent(
    isEmpty = when (uiState) {
      is UiState.Items -> uiState.list.isEmpty()
      is UiState.EmptyState -> uiState.isLoading
    },
    isLoading = uiState.isLoading,
    emptyContent = {
      EmptyListScreen()
    },
    content = {
      ListScreen(
        uiState,
        onItemClick,
        onDeleteClick,
        modifier
      )
    }
  )
}