package com.rapiddeploy.mobile.clearscoretechtask.ui.dashboard

import com.rapiddeploy.mobile.clearscoretechtask.api.support.WebRequestManager
import javax.inject.Inject

class Repository @Inject constructor(private val webRequestManager: WebRequestManager) : CreditDetailsRepository {

    override val creditResponse = webRequestManager.creditResponse

    override fun getCreditDetails() {
        // TODO: Get credit details from api or Room implementation
        webRequestManager.getCreditDetails()
    }
}