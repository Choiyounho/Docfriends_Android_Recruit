package com.soten.di

import com.soten.data.repository.DocFriendsRepository
import com.soten.data.repository.DocFriendsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsDocFriendsRepository(
        docFriendsRepositoryImpl: DocFriendsRepositoryImpl
    ): DocFriendsRepository

}