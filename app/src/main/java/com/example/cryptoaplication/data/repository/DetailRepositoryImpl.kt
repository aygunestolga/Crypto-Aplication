package com.example.cryptoaplication.data.repository

import com.example.cryptoaplication.data.model.detail.CryptoDetailResponse
import com.example.cryptoaplication.data.network.APIService
import com.example.cryptoaplication.domain.repository.DetailRepository
import com.example.cryptoaplication.util.Resource
import javax.inject.Inject

class DetailRepositoryImpl @Inject constructor(
    private val apiService: APIService
) : DetailRepository  {

    override suspend fun getCryptoDetailData(
        apiKey: String,
        cryptoID: String
    ): Resource<CryptoDetailResponse> {
        val response = try {
            apiService.getCryptoDetailData(apiKey, cryptoID)
        } catch (e: Exception) {
            return Resource.Error("Something went wrong!")
        }
        return Resource.Success(response)
    }
}