package com.rapiddeploy.mobile.clearscoretechtask.http.support

import androidx.lifecycle.MutableLiveData
import com.rapiddeploy.mobile.clearscoretechtask.http.model.CreditResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object WebRequestManager {

    val creditResponse = MutableLiveData<CreditResponse?>()

    fun getCreditDetails() {
        val service = ApiService.retrofit.create(CreditInterface::class.java)
        val call = service.getCreditInfo()
        call.enqueue(object : Callback<CreditResponse> {
            override fun onResponse(call: Call<CreditResponse>, response: Response<CreditResponse>) {
                creditResponse.value = response.body()
            }

            override fun onFailure(call: Call<CreditResponse>, t: Throwable) {
                creditResponse.value = null
            }
        })
    }
}