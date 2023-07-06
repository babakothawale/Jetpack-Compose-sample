package com.bk.compose.data.di

import com.bk.compose.data.BookRepository
import com.bk.compose.data.repository.BookRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataDiModule {

    @Binds
    @Singleton
    fun bindBookRepository(bookRepository: BookRepositoryImpl): BookRepository
}