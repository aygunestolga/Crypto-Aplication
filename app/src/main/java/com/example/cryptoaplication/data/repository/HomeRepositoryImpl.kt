package com.example.cryptoaplication.data.repository

import com.example.cryptoaplication.data.model.metadata.CryptoMetaDataResponse
import com.example.cryptoaplication.data.network.APIService
import com.example.cryptoaplication.domain.repository.HomeRepository
import com.example.cryptoaplication.util.Resource
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val apiService: APIService
) : HomeRepository {
    override suspend fun getCryptoMetaData(
        apiKey: String,
        limit: String
    ): Resource<CryptoMetaDataResponse> {
        val response = try {
            apiService.getCryptoMetaData(apiKey,limit)
        }
        catch (_: Exception){
            return Resource.Error("Go Home Boy!!!")
        }
        return Resource.Success(response)
    }
}