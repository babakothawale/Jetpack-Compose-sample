package com.bk.composelistsample.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bk.composelistsample.R
import com.bk.composelistsample.ui.theme.ComposeListSampleTheme

@Preview(showBackground = true)
@Composable
fun CompListRowPreview() {
  ComposeListSampleTheme {
    CompListRow("Android", Modifier)
  }
}

@Composable
fun CompListRow(name: String, modifier: Modifier = Modifier) {
  Row(
    modifier
      .fillMaxWidth()
      .height(48.dp)
  ) {
    ItemImage(modifier = Modifier.padding(end = 16.dp))
    Text(
      text = "${stringResource(id = R.string.hello)} $name",
      modifier = modifier.fillMaxWidth()
    )
  }

}

@Composable
fun ItemImage(modifier: Modifier) {
  Image(
    painter = painterResource(R.mipmap.ic_launcher),
    contentDescription = null, // decorative
    modifier = modifier
      .size(40.dp, 40.dp)
      .clip(MaterialTheme.shapes.small)
  )
}
