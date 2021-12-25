package com.rapiddeploy.mobile.clearscoretechtask.http.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class CreditResponse {
    @SerializedName("accountIDVStatus")
    @Expose
    var accountIDVStatus: String? = null

    @SerializedName("creditReportInfo")
    @Expose
    var creditReportInfo: CreditReportInfo? = null

    @SerializedName("dashboardStatus")
    @Expose
    var dashboardStatus: String? = null

    @SerializedName("personaType")
    @Expose
    var personaType: String? = null

    @SerializedName("coachingSummary")
    @Expose
    var coachingSummary: CoachingSummary? = null

    @SerializedName("augmentedCreditScore")
    @Expose
    var augmentedCreditScore: Any? = null
}