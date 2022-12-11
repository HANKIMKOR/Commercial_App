package com.example.commercial_app

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AwsAPI {

    @GET("/")
    fun getProductInfoAll(
        @Query("shopname") shopName: String
    ): Call<List<RankingData>>

}