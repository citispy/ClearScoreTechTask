package com.rapiddeploy.mobile.clearscoretechtask.api.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class CreditReportInfo {
    @SerializedName("score")
    @Expose
    var score: Int? = 0

    @SerializedName("scoreBand")
    @Expose
    var scoreBand: Int? = 0

    @SerializedName("clientRef")
    @Expose
    var clientRef: String? = null

    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName("maxScoreValue")
    @Expose
    var maxScoreValue: Int? = 0

    @SerializedName("minScoreValue")
    @Expose
    var minScoreValue: Int? = 0

    @SerializedName("monthsSinceLastDefaulted")
    @Expose
    var monthsSinceLastDefaulted: Int? = 0

    @SerializedName("hasEverDefaulted")
    @Expose
    var hasEverDefaulted: Boolean? = null

    @SerializedName("monthsSinceLastDelinquent")
    @Expose
    var monthsSinceLastDelinquent: Int? = 0

    @SerializedName("hasEverBeenDelinquent")
    @Expose
    var hasEverBeenDelinquent: Boolean? = null

    @SerializedName("percentageCreditUsed")
    @Expose
    var percentageCreditUsed: Int? = 0

    @SerializedName("percentageCreditUsedDirectionFlag")
    @Expose
    var percentageCreditUsedDirectionFlag: Int? = 0

    @SerializedName("changedScore")
    @Expose
    var changedScore: Int? = 0

    @SerializedName("currentShortTermDebt")
    @Expose
    var currentShortTermDebt: Int? = 0

    @SerializedName("currentShortTermNonPromotionalDebt")
    @Expose
    var currentShortTermNonPromotionalDebt: Int? = 0

    @SerializedName("currentShortTermCreditLimit")
    @Expose
    var currentShortTermCreditLimit: Int? = 0

    @SerializedName("currentShortTermCreditUtilisation")
    @Expose
    var currentShortTermCreditUtilisation: Int? = 0

    @SerializedName("changeInShortTermDebt")
    @Expose
    var changeInShortTermDebt: Int? = 0

    @SerializedName("currentLongTermDebt")
    @Expose
    var currentLongTermDebt: Int? = 0

    @SerializedName("currentLongTermNonPromotionalDebt")
    @Expose
    var currentLongTermNonPromotionalDebt: Int? = 0

    @SerializedName("currentLongTermCreditLimit")
    @Expose
    var currentLongTermCreditLimit: Any? = null

    @SerializedName("currentLongTermCreditUtilisation")
    @Expose
    var currentLongTermCreditUtilisation: Any? = null

    @SerializedName("changeInLongTermDebt")
    @Expose
    var changeInLongTermDebt: Int? = 0

    @SerializedName("numPositiveScoreFactors")
    @Expose
    var numPositiveScoreFactors: Int? = 0

    @SerializedName("numNegativeScoreFactors")
    @Expose
    var numNegativeScoreFactors: Int? = 0

    @SerializedName("equifaxScoreBand")
    @Expose
    var equifaxScoreBand: Int? = 0

    @SerializedName("equifaxScoreBandDescription")
    @Expose
    var equifaxScoreBandDescription: String? = null

    @SerializedName("daysUntilNextReport")
    @Expose
    var daysUntilNextReport: Int? = 0
}