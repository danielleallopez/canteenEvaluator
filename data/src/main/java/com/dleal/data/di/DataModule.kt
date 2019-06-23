package com.dleal.data.di

import android.content.Context
import androidx.room.Room
import com.dleal.data.BuildConfig
import com.dleal.data.base.local.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * Created by Daniel Leal on 2019-05-26.
 */
val dataModule = module {
    //Database
    single {
        val databaseBuilder = Room.databaseBuilder(androidContext(), AppDatabase::class.java, "canteenDB")
        if (BuildConfig.DEBUG) {
            databaseBuilder.fallbackToDestructiveMigration()
        }

        databaseBuilder.build()
    }

    //SharedPreferences
    single {
        androidContext().getSharedPreferences(
            PREFERENCES,
            Context.MODE_PRIVATE
        )
    }
}

private const val PREFERENCES = "appPreferences"