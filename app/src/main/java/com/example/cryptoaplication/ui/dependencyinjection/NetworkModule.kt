package com.example.cryptoaplication.ui.dependencyinjection

import com.example.cryptoaplication.BuildConfig
import com.example.cryptoaplication.data.network.APIService
import com.example.cryptoaplication.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideHttpLoggerInterceptor() : HttpLoggingInterceptor{
        val httpLoggingInterceptor = HttpLoggingInterceptor()

        if (BuildConfig.DEBUG) httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        else httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE

        return httpLoggingInterceptor
    }

    @Singleton
    @Provides
    fun provideHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor) : OkHttpClient{
        return OkHttpClient.Builder().readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideConvertorFactory() : GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideRetrofitInstance(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ) : Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    //Burada oluşturduğumuz instance'ı APIService ile create edeceğiz
    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit) : APIService{
        return retrofit.create(APIService::class.java )
    }

}