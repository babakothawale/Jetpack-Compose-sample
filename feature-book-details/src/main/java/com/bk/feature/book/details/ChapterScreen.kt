package com.bk.feature.book.details

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelStoreOwner

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChapterScreen(
    modifier: Modifier,
    bookId: String,
    onBack: () -> Unit,
    snackBarHostState: SnackbarHostState = remember { SnackbarHostState() },
    viewModel: BookDetailViewModel = hiltViewModel(viewModelStoreOwner = LocalContext.current as ViewModelStoreOwner)
) {


}