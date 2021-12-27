package com.rapiddeploy.mobile.clearscoretechtask.api.support

import androidx.lifecycle.MutableLiveData
import com.rapiddeploy.mobile.clearscoretechtask.api.model.CreditResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class WebRequestManager @Inject constructor() {

    val creditResponse = MutableLiveData<CreditResponse?>()

    fun getCreditDetails() {
        val call = ApiService.apiInterface.getCreditDetails()
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