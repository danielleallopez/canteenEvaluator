package com.dleal.canteenevaluator.data.base.local.converters

import androidx.room.TypeConverter
import java.util.*

object AppConverters {
    @JvmStatic
    @TypeConverter
    fun fromTimestamp(value: Long): Date? = if (value > 0) Date(value) else null

    @JvmStatic
    @TypeConverter
    fun dateToTimestamp(date: Date?): Long = date?.time ?: -1L
}