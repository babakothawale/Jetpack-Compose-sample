package com.bk.core.data.model

data class Book(val bookId: String, val name: String)
data class BookDetails(val bookId: String, val name: String, val author: String, val description: String)
data class Chapters(val bookId: String, val chapterDetail: String, val title: String, val notes: String)