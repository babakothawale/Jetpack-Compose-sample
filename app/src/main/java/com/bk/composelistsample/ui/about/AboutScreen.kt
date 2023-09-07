package com.bk.composelistsample.ui.about

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bk.compose.core.component.SampleAppBar

@Composable
fun AboutScreen(navigateUp: () -> Unit) {
    Scaffold(
        topBar = {
            SampleAppBar(title = "About", enableHomeUp = true, navigateUp = navigateUp)
        }

    ) {
        SettingContent(modifier = Modifier.padding(it))
    }
}

@Composable
private fun SettingContent(modifier: Modifier) {
    Text(modifier = Modifier.padding(vertical = 16.dp), text = "About the app")
    HorizontalDivider()

}