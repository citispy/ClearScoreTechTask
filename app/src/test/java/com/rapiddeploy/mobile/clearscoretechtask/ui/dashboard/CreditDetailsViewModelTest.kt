package com.rapiddeploy.mobile.clearscoretechtask.ui.dashboard

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.rapiddeploy.mobile.clearscoretechtask.api.model.CreditReportInfo
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CreditDetailsViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: CreditDetailsViewModel
    private var repository = FakeCreditDetailsRepository()

    @Test
    fun `check creditReportInfo values with successful response`() {
        viewModel = CreditDetailsViewModel(repository)

        val observer: Observer<CreditReportInfo?> = Observer {
            if (it != null) {
                assert(it.score == 400)
                assert(it.maxScoreValue == 800)
            }
        }

        viewModel.creditReportInfo.observeForever(observer)
        viewModel.creditReportInfo.removeObserver(observer)
    }

    @Test
    fun `check creditReportInfo values with unsuccessful response`() {
        initViewModelForUnsuccessfulResponse()

        val observer: Observer<CreditReportInfo?> = Observer {
            assert(it == null)
        }

        viewModel.creditReportInfo.observeForever(observer)
        viewModel.creditReportInfo.removeObserver(observer)
    }

    @Test
    fun `check doughnut progress with successful response`() {
        viewModel = CreditDetailsViewModel(repository)

        val observer: Observer<Int> = Observer {
            assert(it == 50)
        }

        viewModel.doughnutProgress.observeForever(observer)
        viewModel.doughnutProgress.removeObserver(observer)
    }

    @Test
    fun `check doughnut progress with unsuccessful response`() {
        initViewModelForUnsuccessfulResponse()

        val observer: Observer<Int> = Observer {
            assert(it == 0)
        }

        viewModel.doughnutProgress.observeForever(observer)
        viewModel.doughnutProgress.removeObserver(observer)
    }

    private fun initViewModelForUnsuccessfulResponse() {
        viewModel = CreditDetailsViewModel(repository)
        repository.creditResponse.value = null
    }
}