package com.soten.di

import com.soten.data.repository.PagingRepository
import com.soten.data.repository.PagingRepositoryImpl
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
    abstract fun bindsPagingRepository(
        pagingRepositoryImpl: PagingRepositoryImpl,
    ): PagingRepository

}