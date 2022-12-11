package com.example.commercial_app

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiObject {
    private const val BASE_URL = "https://trwcnopaakjjmgbkhull234inm0ovqbz.lambda-url.ap-northeast-2.on.aws/"

    private val getRetrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val getProductInfo : AwsAPI by lazy { getRetrofit.create(AwsAPI::class.java) }
}