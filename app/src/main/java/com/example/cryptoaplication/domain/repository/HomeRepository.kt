package com.example.cryptoaplication.domain.repository

import com.example.cryptoaplication.data.model.metadata.CryptoMetaDataResponse
import com.example.cryptoaplication.util.Constants
import com.example.cryptoaplication.util.Resource

interface HomeRepository {

    suspend fun getCryptoMetaData(
        apiKey : String = Constants.API_KEY,
        limit : String = Constants.LIMIT
    ) : Resource<CryptoMetaDataResponse>
}