package com.example.cryptoaplication.domain.repository

import com.example.cryptoaplication.data.model.detail.CryptoDetailResponse
import com.example.cryptoaplication.util.Constants
import com.example.cryptoaplication.util.Resource

interface DetailRepository {
    suspend fun getCryptoDetailData(
        apiKey : String = Constants.API_KEY,
        cryptoID : String
    ) : Resource<CryptoDetailResponse>
}