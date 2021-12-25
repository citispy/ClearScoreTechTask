package com.rapiddeploy.mobile.clearscoretechtask.http.support

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://android-interview.s3.eu-west-2.amazonaws.com/"

object ApiService {

    val retrofit = initRetrofit()

    private fun initRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}