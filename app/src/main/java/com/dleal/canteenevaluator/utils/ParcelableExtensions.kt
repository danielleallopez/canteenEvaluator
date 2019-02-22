package com.dleal.canteenevaluator.utils

import android.os.Parcel
import java.util.*

private fun getDate(longValue: Long) = if (longValue == DEFAULT_LONG_VALUE) null else Date(longValue)

private fun getLongValue(date: Date?) = date?.time ?: DEFAULT_LONG_VALUE

fun Parcel.writeDate(date: Date?) {
    val longValue = getLongValue(date)
    this.writeLong(longValue)
}

fun Parcel.readDate(): Date? {
    val longValue = this.readLong()
    return getDate(longValue)
}

private const val DEFAULT_LONG_VALUE = -1L