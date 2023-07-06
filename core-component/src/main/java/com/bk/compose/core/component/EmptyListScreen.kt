package com.bk.compose.core.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.bk.compose.core.ui.theme.ComposeListSampleTheme

/**
 * Empty message
 */
@Composable
fun EmptyContent() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = stringResource(id = R.string.empty_list), color = MaterialTheme.colorScheme.onSurface
        )
    }
}

/**
 * Full screen circular progress indicator
 */
@Composable
fun FullScreenLoading() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        CircularProgressIndicator()
    }
}

@Preview(showBackground = true)
@Composable
fun ListScreenEmptyPreview() {
    ComposeListSampleTheme {
        EmptyContent()
    }
}

@Preview(showBackground = true)
@Composable
fun FullScreenLoadingPreview() {
    ComposeListSampleTheme {
        FullScreenLoading()
    }
}