package com.bk.composelistsample.ui.settings

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bk.compose.core.component.SampleAppBar
import com.bk.core.data.model.Setting

@Composable
fun SettingScreen(navigateUp: () -> Unit) {
    Scaffold(
        topBar = {
            SampleAppBar(title = "Settings", enableHomeUp = true, navigateUp = navigateUp)
        }

    ) {
        SettingContent(modifier = Modifier.padding(it),
            settings = List(2) { i -> Setting("$i", "setting $i") })
    }

}

@Composable
private fun SettingContent(modifier: Modifier, settings: List<Setting>) {

    LazyColumn(modifier = modifier, contentPadding = PaddingValues(horizontal = 12.dp),
        content = {
            items(settings, key = { it.id }) {
                Text(modifier = Modifier.padding(vertical = 16.dp), text = it.title)
                HorizontalDivider()
            }
        })
}