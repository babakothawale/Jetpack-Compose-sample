package com.bk.feature.books

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bk.compose.core.ui.theme.ComposeListSampleTheme
import com.bk.core.data.model.Book

@Preview(showBackground = true)
@Composable
fun CompListPreview() {
    ComposeListSampleTheme {
        CompList(listOf(), onItemClick = {}, {})
    }
}

@Composable
fun CompList(
    listItems: List<Book>, onItemClick: (Book) -> Unit, onDeleteClick: (Book) -> Unit, modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier, contentPadding = PaddingValues(horizontal = 12.dp),
        //verticalArrangement = Arrangement.spacedBy(12.dp),
        content = {
            items(listItems, key = { it.bookId }) {
                CompListRow(book = it, onItemClick = onItemClick, onDeleteClick = onDeleteClick)
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