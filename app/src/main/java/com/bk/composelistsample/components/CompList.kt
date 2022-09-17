package com.bk.composelistsample.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bk.composelistsample.ui.theme.ComposeListSampleTheme


@Preview(showBackground = true)
@Composable
fun CompListPreview() {
  ComposeListSampleTheme {
    CompList(arrayOf("a", "b").toList())
  }
}

@Composable
fun CompList(listItems: List<String>, modifier: Modifier = Modifier) {
  LazyColumn(modifier = modifier, content = {
    listItems.forEach {
      item { CompListRow(name = it) }
    }
  })
}