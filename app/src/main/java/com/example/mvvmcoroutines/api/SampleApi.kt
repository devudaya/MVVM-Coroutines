package com.example.mvvmcoroutines.api

import com.example.mvvmcoroutines.models.User
import retrofit2.http.GET
import retrofit2.http.Path

interface SampleApi {

    @GET("placeholder/user/{userId}")
    suspend fun getUser(
        @Path("userId") userId: String
    ): User

}