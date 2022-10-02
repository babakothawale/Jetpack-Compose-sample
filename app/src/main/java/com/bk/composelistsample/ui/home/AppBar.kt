package com.bk.composelistsample.ui.home

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.AddAPhoto
import androidx.compose.material.icons.outlined.More
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.bk.composelistsample.R

@Composable
fun Title() {
  Text(text = stringResource(id = R.string.app_name))
}

@Composable
fun NavigationIcon(onNavigationClick: () -> Unit) {
  IconButton(
    onClick = { onNavigationClick() }
  ) {
    Icon(
      imageVector = Icons.Outlined.More,
      contentDescription = stringResource(R.string.app_name)
    )
  }
}

@Composable
fun HomeScreenTopBarActions(onAddPhotoAction: () -> Unit, onAddAction: () -> Unit) {
  Row {
    IconButton(
      onClick = { onAddPhotoAction() }
    ) {
      Icon(
        imageVector = Icons.Outlined.AddAPhoto,
        contentDescription = stringResource(R.string.app_name)
      )
    }
    IconButton(
      onClick = { onAddAction() }
    ) {
      Icon(
        imageVector = Icons.Outlined.Add,
        contentDescription = stringResource(R.string.app_name)
      )
    }
  }

}