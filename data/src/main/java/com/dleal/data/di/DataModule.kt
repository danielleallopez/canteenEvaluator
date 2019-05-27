package com.dleal.data.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.dleal.data.base.local.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Daniel Leal on 2019-05-26.
 */
@Module
class DataModule {
    @Provides
    @Singleton
    fun provideDatabase(context: Context): AppDatabase {
        val databaseBuilder = Room.databaseBuilder(context, AppDatabase::class.java, "canteenDB")
//        if (BuildConfig.DEBUG) {
            databaseBuilder.fallbackToDestructiveMigration()
//        }

        return databaseBuilder.build()
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences = context.getSharedPreferences(
        PREFERENCES,
        Context.MODE_PRIVATE
    )
}

private const val PREFERENCES = "appPreferences"