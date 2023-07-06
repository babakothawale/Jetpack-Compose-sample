package com.bk.composelistsample.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.bk.feature.book.details.BookDetailScreen
import com.bk.feature.books.BookHomeScreen

@Composable
fun MainNavHost(
    modifier: Modifier, navController: NavHostController, startDestination: Destinations = Destinations.BooksHome
) {
    NavHost(navController = navController, modifier = modifier, startDestination = startDestination.route) {
        composable(Destinations.BooksHome.route) {
            BookHomeScreen(Modifier) {
                navController.navigate(Destinations.BookDetails.routeWithParam(it))
            }
        }
        composable(Destinations.BookDetails.routeWithParam) {
            BookDetailScreen(Modifier, it.arguments?.getString("bookId") ?: "", onBack = {
                navController.navigateUp()
            })
        }
    }
}

enum class Destinations(val route: String, val routeWithParam: String) {
    BooksHome("book", "book"),
    BookDetails("bookDetails", "bookDetails/{bookId}")
}

fun Destinations.routeWithParam(param: String): String {
    return "${this.route}/$param"
}