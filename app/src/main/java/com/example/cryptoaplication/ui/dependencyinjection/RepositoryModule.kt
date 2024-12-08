package com.example.cryptoaplication.ui.dependencyinjection

import com.example.cryptoaplication.data.network.APIService
import com.example.cryptoaplication.data.repository.DetailRepositoryImpl
import com.example.cryptoaplication.data.repository.HomeRepositoryImpl
import com.example.cryptoaplication.domain.repository.DetailRepository
import com.example.cryptoaplication.domain.repository.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideHomeRepository(
        apiService: APIService
    ) : HomeRepository{
        return HomeRepositoryImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideDetailRepository(
        apiService: APIService
    ) : DetailRepository{
        return DetailRepositoryImpl(apiService)
    }
}