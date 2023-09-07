package com.bk.feature.books

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.bk.compose.core.component.ListSampleSnackBarHost
import com.bk.compose.core.component.MenuItem
import com.bk.compose.core.component.SampleAppBar
import com.bk.compose.core.component.prepareAppMenus
import kotlinx.coroutines.CoroutineScope

@Composable
fun BookHomeScreen(
    modifier: Modifier,
    snackBarHostState: SnackbarHostState = remember { SnackbarHostState() },
    viewModel: ListViewModel = hiltViewModel(),
    onMenuOptionSelected: (MenuItem) -> Unit,
    navigateToBookDetail: (bookId: String) -> Unit
) {

    val uiState by viewModel.uiState.collectAsState()
    val coroutineScope: CoroutineScope = rememberCoroutineScope()
    Scaffold(snackbarHost = { ListSampleSnackBarHost(snackBarHostState) }, topBar = {
        SampleAppBar(
            title = "Books",
            overflowMenuItems = prepareAppMenus(),
            onOptionSelected = onMenuOptionSelected
        )
//        TopAppBar(colors = TopAppBarDefaults.smallTopAppBarColors(
//            containerColor = MaterialTheme.colorScheme.primaryContainer
//        ), title = { Title() }, navigationIcon = {
//            NavigationIcon({ })
//        }, actions = {
////            TopBarActions(onAddPhotoAction = {
////                coroutineScope.launch {
////                    snackBarHostState.showSnackbar(
////                        "Add photo clicked", "OK", duration = Short
////                    )
////                }
////            }, onAddAction = {
////                coroutineScope.launch {
////                    snackBarHostState.showSnackbar("Add clicked", "OK")
////                }
////            },
////                openWebUrl = openWebUrl
////            )
//        })
    }, modifier = modifier
    ) {
        ListScreenContent(modifier = Modifier.padding(it),
            uiState = uiState,
            onItemClick = { i -> navigateToBookDetail(i.bookId) },
            onDeleteClick = { i -> viewModel.onDeleteClick(i) })
    }

    if (uiState.error.isNotEmpty()) {
        // Remember the errorMessage to display on the screen
        val errorMessage = remember(uiState) { uiState.error }
        val retryMessageText = stringResource(id = R.string.retry)
        val onRefreshState by rememberUpdatedState { viewModel.refresh() }

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

