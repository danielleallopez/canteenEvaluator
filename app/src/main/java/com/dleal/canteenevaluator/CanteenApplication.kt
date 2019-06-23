package com.dleal.canteenevaluator

import android.app.Application
import com.dleal.canteenevaluator.di.mainModule
import com.dleal.core.di.coreModule
import com.dleal.core.di.fabricModule
import com.dleal.data.di.dataModule
import com.dleal.studentcreation.di.studentCreationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CanteenApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin() {
        startKoin {

            if (BuildConfig.DEBUG) {
                androidLogger()
            }

            // use the Android context given there
            androidContext(this@CanteenApplication)

            // module list
            modules(
                appModules
            )
        }
    }
}

val appModules = listOf(
    coreModule,
    mainModule,
    fabricModule,
    dataModule,
    studentCreationModule
)