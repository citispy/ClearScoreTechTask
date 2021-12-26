package com.rapiddeploy.mobile.clearscoretechtask.ui.dashboard

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.rapiddeploy.mobile.clearscoretechtask.R
import com.rapiddeploy.mobile.clearscoretechtask.api.model.CreditReportInfo
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
        observeCreditReportInfo()
        observeDoughnutProgress()
    }

    private fun observeCreditReportInfo() {
        creditDetailsViewModel.creditReportInfo.observe(this, { creditReportInfo ->
            updateUi(creditReportInfo)
        })
    }

    private fun observeDoughnutProgress() {
        creditDetailsViewModel.doughnutProgress.observe(this, { doughnutProgress ->
            binding.doughnut.progress = doughnutProgress
        })
    }

    private fun updateUi(creditReportInfo: CreditReportInfo?) {
        val apiCallSuccessful = creditReportInfo != null
        updateVisibility(apiCallSuccessful)

        if (apiCallSuccessful) {
            updateText(creditReportInfo!!)
        } else {
            displayErrorDialog()
        }
    }

    private fun updateVisibility(apiCallSuccessful : Boolean) {
        binding.loadingProgress.visibility = View.GONE

        if (apiCallSuccessful) {
            binding.textContainer.visibility = View.VISIBLE
            binding.doughnut.visibility = View.VISIBLE
        } else {
            binding.textContainer.visibility = View.GONE
            binding.doughnut.visibility = View.GONE
        }
    }

    private fun updateText(creditReportInfo: CreditReportInfo) {
        val score = creditReportInfo.score.toString()
        val maxScore = creditReportInfo.maxScoreValue.toString()
        val scoreOutOf = getString(R.string.score_out_of, maxScore)

        binding.textScore.text = score
        binding.textOutOf.text = scoreOutOf
    }

    private fun displayErrorDialog() {
        AlertDialog.Builder(requireActivity()).setTitle(getString(R.string.dialog_title))
            .setMessage(getString(R.string.dialog_message))
            .setPositiveButton(getString(R.string.retry)) { _, _ ->
                onRetryClicked()
            }
            .setCancelable(false)
            .show()
    }

    private fun onRetryClicked() {
        binding.loadingProgress.visibility = View.VISIBLE
        creditDetailsViewModel.getCreditDetails()
    }
}