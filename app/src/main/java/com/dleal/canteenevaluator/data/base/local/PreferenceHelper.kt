package com.dleal.canteenevaluator.data.base.local

import android.content.SharedPreferences
import javax.inject.Inject

class PreferenceHelper @Inject constructor(val sharedPreferences: SharedPreferences) {

    private fun edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = sharedPreferences.edit()
        operation(editor)
        editor.apply()
    }

    fun setValue(key: String, value: Any) =
        when (value) {
            is String -> edit { it.putString(key, value) }
            is Int -> edit { it.putInt(key, value) }
            is Boolean -> edit { it.putBoolean(key, value) }
            is Float -> edit { it.putFloat(key, value) }
            is Long -> edit { it.putLong(key, value) }
            else -> throw UnsupportedOperationException("Not yet implemented")
        }

    fun remove(key: String) = edit {
        it.remove(key)
    }

    inline fun <reified T : Any> get(key: String, defaultValue: T): T =
        with(sharedPreferences) {
            when (T::class) {
                String::class -> getString(key, defaultValue as String) as T
                Int::class -> getInt(key, defaultValue as Int) as T
                Boolean::class -> getBoolean(key, defaultValue as Boolean) as T
                Float::class -> getFloat(key, defaultValue as Float) as T
                Long::class -> getLong(key, defaultValue as Long) as T
                else -> throw UnsupportedOperationException("Not yet implemented")
            }
        }
}