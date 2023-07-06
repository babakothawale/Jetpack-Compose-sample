package com.bk.compose.data.repository

import com.bk.compose.data.BookRepository
import com.bk.core.data.model.Book
import com.bk.core.data.model.BookDetails
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(private val ioDispatcher: CoroutineDispatcher) : BookRepository {

    override fun loadBooks(): Flow<List<Book>> {
        return flow {
            delay(3000)
            val data: Int = withContext(ioDispatcher) {
                3
            }
            emit(MutableList(data) { i -> Book(bookId = "$i", "Book $i") })
        }
    }

    override suspend fun loadBookDetail(bookId: String): BookDetails? {
        return withContext(ioDispatcher) {
            delay(3000)

            if (bookId == "0") return@withContext null

            BookDetails(
                bookId = bookId,
                name = "Book $bookId",
                author = "Book $bookId Author",
                description = "Book $bookId description"
            )
        }
    }
}