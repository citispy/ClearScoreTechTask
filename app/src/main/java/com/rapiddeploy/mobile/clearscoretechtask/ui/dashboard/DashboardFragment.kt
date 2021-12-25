package com.rapiddeploy.mobile.clearscoretechtask.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.rapiddeploy.mobile.clearscoretechtask.R
import com.rapiddeploy.mobile.clearscoretechtask.http.model.CreditReportInfo
import com.rapiddeploy.mobile.clearscoretechtask.databinding.FragmentDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private lateinit var binding : FragmentDashboardBinding
    private val creditDetailsViewModel: CreditDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false)
        observeViewModel()
        return binding.root
    }

    private fun observeViewModel() {
        observeCreditReportInfo(creditDetailsViewModel)
        observeDoughnutProgress(creditDetailsViewModel)
    }

    private fun observeCreditReportInfo(creditDetailsViewModel: CreditDetailsViewModel) {
        creditDetailsViewModel.creditReportInfo.observe(this, { creditReportInfo ->
            updateUi(creditReportInfo)
        })
    }

    private fun observeDoughnutProgress(creditDetailsViewModel: CreditDetailsViewModel) {
        creditDetailsViewModel.doughnutProgress.observe(this, { doughnutProgress ->
            binding.doughnut.progress = doughnutProgress
        })
    }

    private fun updateUi(creditReportInfo: CreditReportInfo?) {
        val apiCallSuccessful = creditReportInfo != null
        updateVisibility(apiCallSuccessful)

        if (apiCallSuccessful) {
            updateText(creditReportInfo!!)
        }
    }

    private fun updateVisibility(apiCallSuccessful : Boolean) {
        binding.loadingProgress.visibility = View.GONE

        if (apiCallSuccessful) {
            binding.textContainer.visibility = View.VISIBLE
            binding.doughnut.visibility = View.VISIBLE
        }
    }

    private fun updateText(creditReportInfo: CreditReportInfo) {
        val score = creditReportInfo.score.toString()
        val maxScore = creditReportInfo.maxScoreValue.toString()
        val scoreOutOf = getString(R.string.score_out_of, maxScore)

        binding.textScore.text = score
        binding.textOutOf.text = scoreOutOf
    }
}