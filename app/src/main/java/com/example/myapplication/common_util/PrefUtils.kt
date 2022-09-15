package com.example.myapplication.common_util

import android.content.Context
import androidx.preference.PreferenceManager

object PrefUtils {
    const val KEY_PHONE = "phone"
    const val KEY_EMAIL = "email"
    const val KEY_REMEMBER_ME = "remember_me"
    const val KEY_EMAIL_CACHE = "email_cache"
    const val KEY_PHONE_CACHE = "phone_cache"
    const val KEY_LOGGED_IN = "loggedin"
    const val KEY_ASS_ID = "association_id"
    const val KEY_REQ_ID = "request_id"
    const val KEY_GP_TOKEN = "google_payment_token"

    fun getPhoneNumber(context: Context): String {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(KEY_PHONE, "")
            ?: ""
    }

    fun getBoolean(context: Context?, key: String): Boolean {
        context?.let {
            return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(key, false)
        }
        return false
    }

    fun getString(context: Context, key: String): String? {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(key, "")
    }

    fun removeLoginDataIfExist(context: Context) {
        val sPref = PreferenceManager.getDefaultSharedPreferences(context)
        val rememberMe = sPref.getBoolean(KEY_REMEMBER_ME, false)
        val username = sPref.getString(KEY_EMAIL_CACHE, "")
        val password = sPref.getString(KEY_PHONE_CACHE, "")
        sPref.edit().clear().apply()
        sPref.edit().putBoolean(KEY_REMEMBER_ME, rememberMe).putString(KEY_EMAIL_CACHE, username)
            .putString(KEY_PHONE_CACHE, password).apply()
    }

    fun putBoolean(context: Context?, key: String, enabled: Boolean) {
        context?.let {
            PreferenceManager.getDefaultSharedPreferences(context).edit()
                .putBoolean(key, enabled).apply()
        }
    }

    fun putString(context: Context?, key: String, enabled: String?) {
        context?.let {
            PreferenceManager.getDefaultSharedPreferences(context).edit()
                .putString(key, enabled).apply()
        }
    }
}