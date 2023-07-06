package com.bk.feature.books

import com.bk.core.data.model.Book

data class BooksUiState(val isLoading: Boolean, val error: String = "", val books: List<Book> = arrayListOf())

