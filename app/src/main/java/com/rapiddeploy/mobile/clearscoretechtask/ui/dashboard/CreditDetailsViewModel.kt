package com.rapiddeploy.mobile.clearscoretechtask.ui.dashboard

import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.rapiddeploy.mobile.clearscoretechtask.ui.dashboard.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreditDetailsViewModel @Inject constructor(private val repository: CreditDetailsRepository) : ViewModel() {

    private val creditDetails = repository.creditResponse

    val creditReportInfo = Transformations.map(creditDetails) { it?.creditReportInfo }

    val doughnutProgress = Transformations.map(creditReportInfo) {
            val score = it?.score?.toDouble() ?: 0.0
            val maxScore = it?.maxScoreValue?.toDouble() ?: 0.0
            ((score / maxScore) * 100).toInt()
    }

    fun getCreditDetails() {
        repository.getCreditDetails()
    }

    init {
        getCreditDetails()
    }
}