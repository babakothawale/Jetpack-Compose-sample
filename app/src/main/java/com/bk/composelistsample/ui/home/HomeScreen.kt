package com.bk.composelistsample.ui.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.bk.composelistsample.R
import com.bk.composelistsample.UiState
import com.bk.composelistsample.ui.basiclist.ListScreenContent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Preview
@Composable
fun HomeScreenPreview() {
  HomeScreen(
    uiState = UiState.EmptyState(false, ""),
    onItemClick = {}, onDeleteClick = {},
    onTopBarNavigationClick = {},
    onRefreshRequested = {})
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
  modifier: Modifier = Modifier, uiState: UiState,
  onItemClick: (String) -> Unit,
  onDeleteClick: (String) -> Unit,
  onTopBarNavigationClick: () -> Unit,
  onRefreshRequested: () -> Unit,
  snackBarHostState: SnackbarHostState = remember {
    SnackbarHostState()
  }
) {
  val coroutineScope: CoroutineScope = rememberCoroutineScope()
  Scaffold(
    snackbarHost = { ListSampleSnackBarHost(snackBarHostState) },
    topBar = {
      TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
          containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        title = { Title() },
        navigationIcon = {
          NavigationIcon(onTopBarNavigationClick)
        },
        actions = {
          HomeScreenTopBarActions(
            onAddPhotoAction = {
              coroutineScope.launch {
                snackBarHostState.showSnackbar(
                  "Add photo clicked",
                  "OK",
                  duration = SnackbarDuration.Short
                )
              }
            },
            onAddAction = {
              coroutineScope.launch {
                snackBarHostState.showSnackbar("Add clicked", "OK")
              }
            })
        }
      )
    },
    modifier = modifier
  ) {
    ListScreenContent(
      modifier = Modifier.padding(it),
      uiState = uiState,
      onItemClick = onItemClick,
      onDeleteClick = onDeleteClick
    )
  }

  if (uiState.error.isNotEmpty()) {
    // Remember the errorMessage to display on the screen
    val errorMessage = remember(uiState) { uiState.error }
    val retryMessageText = stringResource(id = R.string.retry)
    val onRefreshState by rememberUpdatedState(onRefreshRequested)

    LaunchedEffect(errorMessage, retryMessageText, snackBarHostState) {
      val snackbarResult = snackBarHostState.showSnackbar(
        message = errorMessage,
        actionLabel = retryMessageText,
        duration = SnackbarDuration.Long
      )
      if (snackbarResult == SnackbarResult.ActionPerformed) {
        onRefreshState()
      }
    }
  }
}

@Composable
fun ShowToast(message: String, actionLabel: String, snackBarHostState: SnackbarHostState) {
  LaunchedEffect(key1 = message, key2 = snackBarHostState) {
    snackBarHostState.showSnackbar(message, actionLabel)
  }
}

