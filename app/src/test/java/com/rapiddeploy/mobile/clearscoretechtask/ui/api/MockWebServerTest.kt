package com.rapiddeploy.mobile.clearscoretechtask.ui.api

import com.rapiddeploy.mobile.clearscoretechtask.api.model.CreditResponse
import com.rapiddeploy.mobile.clearscoretechtask.api.support.ApiService
import com.rapiddeploy.mobile.clearscoretechtask.ui.dashboard.utils.MockResponseFileReader
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.json.JSONObject
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Call
import retrofit2.Response
import java.net.HttpURLConnection

@RunWith(MockitoJUnitRunner::class)
class MockWebServerTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var call: Call<CreditResponse>
    private lateinit var response: MockResponse
    private lateinit var actualResponse: Response<CreditResponse>

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        mockWebServer = MockWebServer()
        mockWebServer.start()

        response = getResponse()
        call = ApiService.apiInterface.getCreditDetails()
        actualResponse = call.execute()
    }

    private fun getResponse(): MockResponse {
        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(MockResponseFileReader("successful_response.json").content)
        mockWebServer.enqueue(response)
        return response
    }

    @Test
    fun `read sample success json file`() {
        val reader = MockResponseFileReader("successful_response.json")
        assertNotNull(reader.content)
    }

    @Test
    fun `fetch details and check response Code 200 returned`(){
        assertEquals(response.toString().contains("200"),actualResponse.code().toString().contains("200"))
    }

    @Test
    fun `check response values`() {
        val creditResponse = actualResponse.body()
        val creditReportInfo = creditResponse?.creditReportInfo

        assertNotNull(creditResponse)
        assert(creditResponse is CreditResponse)
        assertEquals(514, creditReportInfo?.score)
        assertEquals(700, creditReportInfo?.maxScoreValue)
    }

    @After
    fun teardown() {
        mockWebServer.shutdown()
    }
}