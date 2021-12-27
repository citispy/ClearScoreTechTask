package com.rapiddeploy.mobile.clearscoretechtask.api.support

import com.rapiddeploy.mobile.clearscoretechtask.api.model.CreditResponse
import retrofit2.Call
import retrofit2.http.GET

interface CreditInterface {
    @GET("endpoint.json")
    fun getCreditInfo() : Call<CreditResponse>
}