package com.bk.feature.book.details

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bk.compose.data.BookRepository
import com.bk.core.data.model.BookDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookDetailViewModel @Inject constructor(private val bookRepository: BookRepository) :
    ViewModel() {

    private val _bookDetailStateFlow = MutableStateFlow(BookDetailUiState(true))
    val bookDetailsUiState = _bookDetailStateFlow.stateIn(
        viewModelScope, SharingStarted.Eagerly, BookDetailUiState(isLoading = true)
    )

    fun loadBookDetails(bookId: String) {
        viewModelScope.launch {
            bookRepository.loadBookDetail(bookId = bookId).catch {
                _bookDetailStateFlow.value =
                    BookDetailUiState(isLoading = false, it.message ?: " error occurred")
            }.collect() {
                _bookDetailStateFlow.value = BookDetailUiState(isLoading = false, bookDetail = it)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("BookDetailViewModel", "onCleared: $this")
    }
}

data class BookDetailUiState(
    val isLoading: Boolean, val error: String = "", val bookDetail: BookDetails? = null
)
