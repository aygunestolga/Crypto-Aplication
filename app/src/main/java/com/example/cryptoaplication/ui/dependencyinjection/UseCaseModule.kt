package com.example.cryptoaplication.ui.dependencyinjection

import com.example.cryptoaplication.domain.repository.DetailRepository
import com.example.cryptoaplication.domain.repository.HomeRepository
import com.example.cryptoaplication.domain.usecase.GetCryptoDetailUseCase
import com.example.cryptoaplication.domain.usecase.GetCryptoListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideGetCryptoListUseCase(
        homeRepository: HomeRepository
    ) : GetCryptoListUseCase {
        return GetCryptoListUseCase(homeRepository)
    }

    @Singleton
    @Provides
    fun provideGetCryptoDetailUseCase(
        detailRepository: DetailRepository
    ) : GetCryptoDetailUseCase {
        return GetCryptoDetailUseCase(detailRepository)
    }
}