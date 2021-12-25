package com.rapiddeploy.mobile.clearscoretechtask.http.support

import com.rapiddeploy.mobile.clearscoretechtask.http.model.CreditResponse
import retrofit2.Call
import retrofit2.http.GET

interface CreditInterface {
    @GET("endpoint.json")
    fun getCreditInfo() : Call<CreditResponse>
}