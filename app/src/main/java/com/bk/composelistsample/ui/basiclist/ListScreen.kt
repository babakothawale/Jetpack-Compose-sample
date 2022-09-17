package com.bk.composelistsample.ui.basiclist

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bk.composelistsample.components.CompList
import com.bk.composelistsample.ui.theme.ComposeListSampleTheme

@Preview(showBackground = true)
@Composable
fun ListScreenPreview() {
  ComposeListSampleTheme {
    ListScreen(arrayOf("a", "b").toList())
  }
}

@Composable
fun ListScreen(items: List<String>, modifier: Modifier = Modifier) {
  CompList(listItems = items, modifier = modifier)
}