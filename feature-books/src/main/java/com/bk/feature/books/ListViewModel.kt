package com.bk.feature.books

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bk.compose.data.BookRepository
import com.bk.core.data.model.Book
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val bookRepository: BookRepository) : ViewModel() {

    val uiState = bookRepository.loadBooks().map {
        BooksUiState(isLoading = false, books = it)
    }.catch {
        BooksUiState(isLoading = false, error = it.message ?: "Error occurred")
    }.stateIn(
        viewModelScope, SharingStarted.Eagerly, BooksUiState(isLoading = true)
    )

    fun refresh() {
    }

    fun onDeleteClick(book: Book) {
    }
}


