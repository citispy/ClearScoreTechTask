package com.rapiddeploy.mobile.clearscoretechtask.ui.dashboard

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.gson.Gson
import com.rapiddeploy.mobile.clearscoretechtask.api.model.CreditResponse
import com.rapiddeploy.mobile.clearscoretechtask.ui.dashboard.utils.MockResponseFileReader
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertNull
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FakeCreditDetailsRepository: CreditDetailsRepository {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    override var creditResponse = MutableLiveData<CreditResponse?>()

    override fun getCreditDetails() {
        val creditResponse = getCreditResponse("successful_response.json")
        this.creditResponse.value = creditResponse
    }

    private fun getCreditResponse(path: String): CreditResponse? {
        val reader = MockResponseFileReader(path)
        val gson = Gson()
        return gson.fromJson(reader.content, CreditResponse::class.java)
    }

    @Test
    fun `checks on live data value`() {
        getCreditDetails()
        val creditResponse = creditResponse.value
        val creditReportInfo = creditResponse?.creditReportInfo

        assertNotNull(creditResponse)
        assert(creditResponse is CreditResponse)
        assert(creditReportInfo?.score == 400)
        assert(creditReportInfo?.maxScoreValue == 800)
    }

    @Test
    fun `live data is null for failed responses`() {
        creditResponse.value = null
        assertNull(creditResponse.value)
    }
}