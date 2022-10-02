package com.bk.composelistsample

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {

  private val listViewModelState = MutableStateFlow(ListState(isLoading = true))

  val uiState = listViewModelState.map {
    it.toUiState()
  }.stateIn(
    viewModelScope, SharingStarted.Eagerly, listViewModelState.value.toUiState()
  )

  init {
    refresh()
  }

  fun refresh() {
    viewModelScope.launch {
      listViewModelState.update {
        it.copy(isLoading = true, error = "", items = null)
      }
      listViewModelState.value = generateData()
    }
  }

  /**
   * To test empty uncomment the empty list copy state
   */
  private suspend fun generateData(): ListState {
    delay(3000)
    return listViewModelState.value.copy(isLoading = false, items = MutableList(50) { i -> "$i" })
    //Error state
//    return listViewModelState.value.copy(
//      isLoading = false, items = arrayListOf(), error = "Error while loading data!"
//    )
    //Empty state
//    return listViewModelState.value.copy(isLoading = false, items = arrayListOf())
  }

  fun onItemClick(name: String) {
    Log.d("ListViewModel", "onItemClick: $name")
  }

  fun onDeleteClick(name: String) {
    Log.d("ListViewModel", "onDeleteClick: $name")
    listViewModelState.update { state ->
      state.copy(items = state.items?.filter { it != name })
    }
  }
}

/**
 * This will contains available data
 */
private data class ListState(
  val isLoading: Boolean, val error: String = "", val items: List<String>? = null
) {
  /**
   * Create state with only required data to update UI
   */
  fun toUiState(): UiState {
    return if (items == null) {
      UiState.EmptyState(isLoading = isLoading, error = error)
    } else {
      UiState.Items(isLoading = isLoading, error = error, list = items)
    }
  }
}


