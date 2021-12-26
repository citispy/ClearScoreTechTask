package com.rapiddeploy.mobile.clearscoretechtask.api.support

import com.rapiddeploy.mobile.clearscoretechtask.ui.dashboard.CreditDetailsRepository
import com.rapiddeploy.mobile.clearscoretechtask.ui.dashboard.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun providesRepository(webRequestManager: WebRequestManager) = Repository(webRequestManager) as CreditDetailsRepository
}