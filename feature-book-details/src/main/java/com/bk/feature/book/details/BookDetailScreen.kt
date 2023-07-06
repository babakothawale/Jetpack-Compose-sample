package com.bk.feature.book.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration.Short
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.bk.compose.core.component.EmptyContent
import com.bk.compose.core.component.HomeScreenTopBarActions
import com.bk.compose.core.component.ListSampleSnackBarHost
import com.bk.compose.core.component.LoadingScreenContent
import com.bk.compose.core.component.NavigationIcon
import com.bk.compose.core.component.Title
import com.bk.core.data.model.BookDetails
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookDetailScreen(
    modifier: Modifier,
    bookId: String,
    onBack: () -> Unit,
    snackBarHostState: SnackbarHostState = remember { SnackbarHostState() },
    viewModel: BookDetailViewModel = hiltViewModel()
) {

    val uiState by viewModel.bookDetailsUiState.collectAsState()
    viewModel.loadBookDetails(bookId)
    val coroutineScope: CoroutineScope = rememberCoroutineScope()
    Scaffold(snackbarHost = { ListSampleSnackBarHost(snackBarHostState) }, topBar = {
        TopAppBar(colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ), title = { Title() }, navigationIcon = {
            NavigationIcon { onBack() }
        }, actions = {
            HomeScreenTopBarActions(onAddPhotoAction = {
                coroutineScope.launch {
                    snackBarHostState.showSnackbar(
                        "Add photo clicked", "OK", duration = Short
                    )
                }
            }, onAddAction = {
                coroutineScope.launch {
                    snackBarHostState.showSnackbar("Add clicked", "OK")
                }
            })
        })
    }, modifier = modifier
    ) {
        LoadingScreenContent(isEmpty = uiState.bookDetail == null, isLoading = uiState.isLoading, emptyContent = {
            EmptyContent()
        }, content = {
            BookDetails(modifier = modifier.padding(it), bookDetails = uiState.bookDetail!!)
        })
    }
}

@Composable
fun BookDetails(modifier: Modifier, bookDetails: BookDetails) {
    Column(modifier) {
        Text(text = "${bookDetails.description}")
    }
}