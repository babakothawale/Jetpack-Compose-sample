package com.bk.composelistsample.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.bk.compose.core.ui.theme.ComposeListSampleTheme

@Composable
@Preview(showBackground = true)
fun PreviewApp() {
    ComposeListSampleTheme() {
        App()
    }
}

@Composable
fun App() {
    MainNavHost(Modifier, navController = rememberNavController())
}