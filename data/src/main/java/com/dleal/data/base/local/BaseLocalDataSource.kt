package com.dleal.data.base.local

import org.koin.core.KoinComponent
import org.koin.core.inject

abstract class BaseLocalDataSource : KoinComponent {

    protected val preferenceHelper: PreferenceHelper by inject()

    protected val appDatabase: AppDatabase by inject()
}