package com.example.cryptoaplication.domain.usecase

import com.example.cryptoaplication.data.model.metadata.CryptoMetaDataResponse
import com.example.cryptoaplication.domain.repository.HomeRepository
import com.example.cryptoaplication.util.Resource
import javax.inject.Inject

class GetCryptoListUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    suspend fun execute(

    ) : Resource<CryptoMetaDataResponse>{
        return homeRepository.getCryptoMetaData()
    }
}