package com.example.cryptoaplication.domain.usecase

import com.example.cryptoaplication.data.model.detail.CryptoDetailResponse
import com.example.cryptoaplication.domain.repository.DetailRepository
import com.example.cryptoaplication.util.Resource
import javax.inject.Inject

class GetCryptoDetailUseCase @Inject constructor(
    private val detailRepository: DetailRepository
) {
    suspend fun execute(
        cryptoID : String
    ) : Resource<CryptoDetailResponse>{
        return detailRepository.getCryptoDetailData(cryptoID=cryptoID)
    }
}