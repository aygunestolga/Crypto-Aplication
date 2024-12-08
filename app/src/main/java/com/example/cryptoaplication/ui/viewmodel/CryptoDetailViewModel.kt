package com.example.cryptoaplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.cryptoaplication.data.model.detail.CryptoDetailResponse
import com.example.cryptoaplication.domain.usecase.GetCryptoDetailUseCase
import com.example.cryptoaplication.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CryptoDetailViewModel @Inject constructor(
    private val getCryptoDetailUseCase: GetCryptoDetailUseCase
) : ViewModel(){
    suspend fun loadCryptoDetailData(
        cryptoID : String
    ) : Resource<CryptoDetailResponse>{
        return getCryptoDetailUseCase.execute(cryptoID)
    }
}