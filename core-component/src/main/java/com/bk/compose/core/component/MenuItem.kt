package com.bk.compose.core.component

import androidx.compose.ui.graphics.vector.ImageVector

data class MenuItem(val id: Int, val title: String, val icon: ImageVector, val data: Any? = null)