package com.dleal.canteenevaluator.data.base.local.converters

import androidx.room.TypeConverter
import java.util.*

object AppConverters {
    @JvmStatic
    @TypeConverter
    fun fromTimestamp(value: Long): Date = Date(value)

    @JvmStatic
    @TypeConverter
    fun dateToTimestamp(date: Date): Long = date.time
}