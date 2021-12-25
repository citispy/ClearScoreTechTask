package com.rapiddeploy.mobile.clearscoretechtask.ui.dashboard

import com.rapiddeploy.mobile.clearscoretechtask.http.support.WebRequestManager

object Repository {
    val creditResponse = WebRequestManager.creditResponse

    fun getCreditDetails() {
        // TODO: Get credit details from api or Room implementation
        WebRequestManager.getCreditDetails()
    }
}