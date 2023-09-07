package com.bk.composelistsample.ui

enum class Destinations(val route: String, val routeWithParam: String) {
    BooksHome("book", "book"),
    BookDetails("bookDetails", "bookDetails/{bookId}"),
    WebScreen("webScreen", "webScreen?url={url}"),
    Settings("settings", "settings"),
    About("about", "about"),

}