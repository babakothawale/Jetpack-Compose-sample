package com.bk.compose.core.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SampleAppBar(
    title: String,
    subTitle: String = "",
    enableHomeUp: Boolean = false,
    navigateUp: () -> Unit = {},
    visibleMenuItems: List<MenuItem> = listOf(),
    overflowMenuItems: List<MenuItem> = listOf(),
    onOptionSelected: (MenuItem) -> Unit = {}
) {
    TopAppBar(colors = TopAppBarDefaults.largeTopAppBarColors(
        containerColor = MaterialTheme.colorScheme.primaryContainer
    ), title = { Title(title, subTitle) }, navigationIcon = {
        if (enableHomeUp) {
            NavigationIcon(navigateUp)
        }
    }, actions = {
        TopBarActions(
            visibleOptions = visibleMenuItems,
            overflowOptions = overflowMenuItems,
            onOptionSelected = onOptionSelected
        )
    })
}