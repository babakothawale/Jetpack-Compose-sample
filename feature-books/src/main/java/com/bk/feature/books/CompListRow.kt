package com.bk.feature.books

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bk.compose.core.ui.theme.ComposeListSampleTheme
import com.bk.core.data.model.Book

@Preview(showBackground = true)
@Composable
fun CompListRowPreview() {
    ComposeListSampleTheme {
        CompListRow(book = Book("1", "dummy book"), onItemClick = {}, {})
    }
}

@Composable
fun CompListRow(
    book: Book, onItemClick: (Book) -> Unit, onDeleteClick: (Book) -> Unit, modifier: Modifier = Modifier
) {
    Row(
        modifier
            .clickable(onClick = { onItemClick(book) })
            .fillMaxWidth(),
        //.padding(8.dp)
        //.height(48.dp)
        verticalAlignment = Alignment.CenterVertically,

        ) {
        ItemImage(modifier = Modifier.padding(end = 16.dp), Icons.Outlined.Person)
        Text(
            text = "${stringResource(id = R.string.hello)} ${book.name}", Modifier.weight(1f)
            //.padding(end = 16.dp)
        )
        Button(onClick = { onDeleteClick(book) }) {
            Text(text = stringResource(id = R.string.delete))
        }
    }
}

@Composable
fun ItemImage(modifier: Modifier, imageVector: ImageVector) {
    Image(
        imageVector,
        contentDescription = "Book Image",
        modifier = modifier
            .size(40.dp, 40.dp)
            .clip(MaterialTheme.shapes.small)
    )
}
