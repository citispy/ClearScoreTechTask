package com.rapiddeploy.mobile.clearscoretechtask.ui.dashboard

import androidx.lifecycle.MutableLiveData
import com.rapiddeploy.mobile.clearscoretechtask.api.model.CreditResponse

interface CreditDetailsRepository {
    val creditResponse: MutableLiveData<CreditResponse?>
    fun getCreditDetails()
}