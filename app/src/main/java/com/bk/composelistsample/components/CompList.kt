package com.bk.composelistsample.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bk.composelistsample.ui.theme.ComposeListSampleTheme


@Preview(showBackground = true)
@Composable
fun CompListPreview() {
  ComposeListSampleTheme {
    CompList(arrayOf("a", "b").toList(), onItemClick = {}, {})
  }
}

@Composable
fun CompList(
  listItems: List<String>, onItemClick: (String) -> Unit,
  onDeleteClick: (String) -> Unit,
  modifier: Modifier = Modifier
) {
  LazyColumn(
    modifier = modifier,
    contentPadding = PaddingValues(horizontal = 12.dp),
    //verticalArrangement = Arrangement.spacedBy(12.dp),
    content = {
      items(listItems, key = { it }) {
        CompListRow(name = it, onItemClick = onItemClick, onDeleteClick = onDeleteClick)
        ListItemDivider()
      }
    })
}

@Composable
private fun ListItemDivider() {
  Divider(
    //modifier = Modifier.padding(horizontal = 14.dp),
    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.08f)
  )
}