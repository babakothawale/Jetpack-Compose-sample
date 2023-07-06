package com.bk.feature.books

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bk.core.data.model.Book
import com.bk.compose.data.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val bookRepository: BookRepository) : ViewModel() {

    val uiState = bookRepository.loadBooks().map {
        BooksUiState(isLoading = false, books = it)
    }.catch {
        BooksUiState(isLoading = false, error = it.message ?: "Error occured")
    }.stateIn(
        viewModelScope, SharingStarted.Eagerly, BooksUiState(isLoading = true)
    )

    fun refresh() {
    }

    fun onDeleteClick(book: Book) {
    }
}


