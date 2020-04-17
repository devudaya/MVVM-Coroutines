package com.example.mvvmcoroutines.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {

    private const val BASE_URL: String = "https://open-api.xyz/"

    private val retrofitBuilder: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    val apiService: SampleApi by lazy{
        retrofitBuilder.build().create(SampleApi::class.java)
    }
}