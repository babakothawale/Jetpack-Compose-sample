package com.bk.compose.data

import com.bk.core.data.model.Book
import com.bk.core.data.model.BookDetails
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    fun loadBooks(): Flow<List<Book>>
    fun loadBookDetail(bookId: String): Flow<BookDetails>
}