package com.dleal.canteenevaluator.data.base.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dleal.canteenevaluator.BuildConfig
import com.dleal.canteenevaluator.data.base.local.converters.AppConverters
import com.dleal.canteenevaluator.data.dto.StudentDao
import com.dleal.canteenevaluator.data.dto.StudentData

@Database(
    entities = [
        StudentData::class
    ],
    version = BuildConfig.DATABASE_VERSION
)

@TypeConverters(AppConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getTranslationsDao(): StudentDao
}