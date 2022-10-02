package com.bk.composelistsample.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bk.composelistsample.R
import com.bk.composelistsample.ui.theme.ComposeListSampleTheme

@Preview(showBackground = true)
@Composable
fun CompListRowPreview() {
  ComposeListSampleTheme {
    CompListRow(name = "Android", onItemClick = {}, {})
  }
}

@Composable
fun CompListRow(
  name: String,
  onItemClick: (String) -> Unit,
  onDeleteClick: (String) -> Unit,
  modifier: Modifier = Modifier
) {
  Row(
    modifier
      .clickable(onClick = { onItemClick(name) })
      .fillMaxWidth()
      //.padding(8.dp)
      //.height(48.dp)
        ,
    verticalAlignment = Alignment.CenterVertically,

  ) {
    ItemImage(modifier = Modifier.padding(end = 16.dp))
    Text(
      text = "${stringResource(id = R.string.hello)} $name",
      Modifier.weight(1f)
      //.padding(end = 16.dp)
    )
    Button(
      onClick = { onDeleteClick(name) }) {
      Text(text = stringResource(id = R.string.delete))
    }
  }
}

@Composable
fun ItemImage(modifier: Modifier) {
  Image(
    painter = painterResource(R.mipmap.ic_launcher),
    contentDescription = null,
    modifier = modifier
      .size(40.dp, 40.dp)
      .clip(MaterialTheme.shapes.small)
  )
}
