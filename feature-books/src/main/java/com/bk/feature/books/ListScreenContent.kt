package com.bk.feature.books

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bk.compose.core.component.EmptyContent
import com.bk.compose.core.component.LoadingScreenContent
import com.bk.compose.core.ui.theme.ComposeListSampleTheme
import com.bk.core.data.model.Book

@Preview(showBackground = true)
@Composable
fun ListScreenContentPreview() {
    ComposeListSampleTheme {
        ListScreenContent(BooksUiState(isLoading = false, books = List(2) { i -> Book("$i", "Book $i") }), {}, {})
    }
}

@Composable
fun ListScreenContent(
    uiState: BooksUiState,
    onItemClick: (Book) -> Unit,
    onDeleteClick: (Book) -> Unit,
    modifier: Modifier = Modifier,
) {
    LoadingScreenContent(isEmpty = uiState.books.isEmpty(), isLoading = uiState.isLoading, emptyContent = {
        EmptyContent()
    }, content = {
        CompList(
            listItems = uiState.books,
            onItemClick = onItemClick,
            onDeleteClick = onDeleteClick,
            modifier = modifier
        )
    })
}