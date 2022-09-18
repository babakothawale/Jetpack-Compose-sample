package com.bk.composelistsample.ui.basiclist

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bk.composelistsample.UiState
import com.bk.composelistsample.components.CompList
import com.bk.composelistsample.ui.theme.ComposeListSampleTheme

@Preview(showBackground = true)
@Composable
fun ListScreenPreview() {
  ComposeListSampleTheme {
    ListScreen(UiState.Items(false, "", List(2) { i -> "$i" }), {})
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
  uiState: UiState, onItemClick: (String) -> Unit, modifier: Modifier = Modifier
) {
  val items = when (uiState) {
    is UiState.Items -> uiState.list
    is UiState.EmptyState -> arrayListOf()
  }

  CompList(listItems = items, onItemClick, modifier = modifier)
}