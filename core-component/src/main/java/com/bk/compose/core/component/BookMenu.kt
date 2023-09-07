package com.bk.compose.core.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings


fun prepareAppMenus(): List<MenuItem> {
    return mutableListOf<MenuItem>().apply {
        add(MenuItem(id = AppMenus.ID_SETTING, title = "Settings", icon = Icons.Outlined.Settings))
        add(
            MenuItem(
                id = AppMenus.ID_PRIVACY_POLICY,
                title = "Privacy Policy",
                icon = Icons.Outlined.Info,
                data = "https:\\/\\/developer.google.com"
            )
        )
        add(
            MenuItem(
                id = AppMenus.ID_TnC,
                title = "Terms & Conditions",
                icon = Icons.Outlined.Info,
                data = "https:\\/\\/developer.google.com"
            )
        )
        add(MenuItem(id = AppMenus.ID_ABOUT, title = "About", icon = Icons.Outlined.Info))
    }
}