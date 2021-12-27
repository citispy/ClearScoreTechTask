package com.rapiddeploy.mobile.clearscoretechtask.api.support

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://android-interview.s3.eu-west-2.amazonaws.com/"

object ApiService {

    val apiInterface: ApiInterface = initRetrofit().create(ApiInterface::class.java)

    private fun initRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}