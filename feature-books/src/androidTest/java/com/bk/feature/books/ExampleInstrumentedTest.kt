package com.bk.feature.books

import androidx.compose.material3.SnackbarHostState
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.bk.compose.core.ui.theme.ComposeListSampleTheme
import com.bk.core.data.model.Book

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

class MyComposeTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    // use createAndroidComposeRule<YourActivity>() if you need access to
    // an activity

    @Test
    fun loaderTest() {
        val uiState = BooksUiState(isLoading = false, books = List<Book>(1){ Book("$it", "book $it")})
//        val uiState = BooksUiState(isLoading = false)
        // Start the app
        composeTestRule.setContent {
            ComposeListSampleTheme() {
                ListScreenContent(uiState = uiState, modifier = Modifier, onDeleteClick = {}, onItemClick = {})
            }
        }

        composeTestRule.onNodeWithText("No items to show!").assertIsDisplayed()

       // composeTestRule.onNode().assertIsDisplayed()
    }
}