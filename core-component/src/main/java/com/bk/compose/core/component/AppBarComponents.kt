package com.bk.compose.core.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun Title(title: String, subTitle: String) {
    Column {
        Text(text = title)
        if (subTitle.isNotEmpty()) {
            Text(text = subTitle)
        }
    }

}

@Composable
fun NavigationIcon(onNavigationClick: () -> Unit) {
    IconButton(
        onClick = { onNavigationClick() }
    ) {
        Icon(
            imageVector = Icons.Outlined.ArrowBack,
            contentDescription = stringResource(R.string.app_name)
        )
    }
}

@Composable
fun TopBarActions(
    visibleOptions: List<MenuItem>,
    overflowOptions: List<MenuItem>,
    onOptionSelected: (MenuItem) -> Unit,
    menuExpanded: MutableState<Boolean> = remember {
        mutableStateOf(false)
    }
) {

    for (menuItem in visibleOptions) {
        IconButton(
            onClick = { onOptionSelected(menuItem) }
        ) {
            Row {
                Icon(menuItem.icon, contentDescription = menuItem.title)
                //Text(text = menuItem.title)
            }
        }
    }

    if (overflowOptions.isNotEmpty()) {
        IconButton(
            onClick = { menuExpanded.value = true }
        ) {
            Icon(
                imageVector = Icons.Outlined.MoreVert,
                contentDescription = "More options"
            )
        }

        DropdownMenu(
            expanded = menuExpanded.value,
            onDismissRequest = { menuExpanded.value = false }) {
            for (menuItem in overflowOptions) {
                DropdownMenuItem(
                    text = {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(menuItem.icon, contentDescription = menuItem.title)
                            Text(text = menuItem.title)
                        }

                    },
                    onClick = { onOptionSelected(menuItem) })
            }
        }
    }

}