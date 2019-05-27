package com.dleal.data.base.local

import javax.inject.Inject

abstract class BaseLocalDataSource {

    @Inject
    lateinit var preferenceHelper: PreferenceHelper

    @Inject
    lateinit var appDatabase: AppDatabase
}