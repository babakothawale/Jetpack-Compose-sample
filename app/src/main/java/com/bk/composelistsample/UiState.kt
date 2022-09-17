package com.bk.composelistsample

sealed interface UiState {
  val isLoading: Boolean
  val error: String

  data class EmptyState(override val isLoading: Boolean, override val error: String) : UiState

  data class Items(
    override val isLoading: Boolean,
    override val error: String,
    val list: List<String>
  ) : UiState
}

