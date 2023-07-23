package com.bk.compose.data.repository

import com.bk.compose.data.BookRepository
import com.bk.compose.data.di.DefaultDispatcher
import com.bk.core.data.model.Book
import com.bk.core.data.model.BookDetails
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(@DefaultDispatcher private val ioDispatcher: CoroutineDispatcher) : BookRepository {

    override fun loadBooks(): Flow<List<Book>> {
        return flow {
            delay(3000)
            val data: Int = withContext(ioDispatcher) {
                3
            }
            emit(MutableList(data) { i -> Book(bookId = "$i", "Book $i") })
        }
    }

    override fun loadBookDetail(bookId: String): Flow<BookDetails> {
        return flow {
            //withContext(ioDispatcher) {
                delay(1000)

                if (bookId == "0") throw Exception("invalid bookId")

                emit(BookDetails(
                    bookId = bookId,
                    name = "Book $bookId",
                    author = "Book $bookId Author",
                    description = "Book $bookId description"
                ))
            //}
        }
    }
}