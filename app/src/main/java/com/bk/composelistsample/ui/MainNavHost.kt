package com.bk.composelistsample.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.bk.compose.core.component.MenuItem
import com.bk.compose.core.component.AppMenus
import com.bk.composelistsample.ui.about.AboutScreen
import com.bk.composelistsample.ui.settings.SettingScreen
import com.bk.composelistsample.ui.webview.WebViewScreen
import com.bk.feature.book.details.BookDetailScreen
import com.bk.feature.books.BookHomeScreen

@Composable
fun MainNavHost(
    modifier: Modifier,
    navController: NavHostController,
    startDestination: Destinations = Destinations.BooksHome
) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination.route
    ) {
        composable(Destinations.BooksHome.route) {
            BookHomeScreen(
                Modifier,
                onMenuOptionSelected = { onOptionsItemSelected(it, navController) }) {
                navController.navigate(Destinations.BookDetails.route + "/$it")
            }
        }
        composable(Destinations.BookDetails.routeWithParam) {
            BookDetailScreen(Modifier, it.arguments?.getString("bookId") ?: "", onBack = {
                navController.navigateUp()
            })
        }
        composable(
            Destinations.WebScreen.routeWithParam,
            arguments = listOf(navArgument(name = "url") {
                type = NavType.StringType
            })
        ) {
            val url = it.arguments?.getString("url") ?: ""
            WebViewScreen(url = url, onBackPressed = {
                navController.navigateUp()
            })
        }
        composable(Destinations.Settings.route) {
            SettingScreen(navigateUp = {
                navController.navigateUp()
            })
        }

        composable(Destinations.About.route) {
            AboutScreen(navigateUp = {
                navController.navigateUp()
            })
        }

    }
}

private fun onOptionsItemSelected(menuItem: MenuItem, navController: NavHostController) {
    when (menuItem.id) {
        AppMenus.ID_SETTING -> {
            navController.navigateToSetting()
        }

        AppMenus.ID_ABOUT -> {
            navController.navigateToAbout()
        }

        AppMenus.ID_PRIVACY_POLICY,
        AppMenus.ID_TnC,
        -> {
            navController.navigateToWebScreen(menuItem.data!!.toString())
        }
    }
}

private fun NavHostController.navigateToWebScreen(url: String) {
    navigate(Destinations.WebScreen.route + "?url=$url")
}

private fun NavHostController.navigateToSetting() {
    navigate(Destinations.Settings.route)
}

private fun NavHostController.navigateToAbout() {
    navigate(Destinations.About.route)
}

