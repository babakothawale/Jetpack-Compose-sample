package com.bk.compose.core.component

import androidx.compose.runtime.Composable

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