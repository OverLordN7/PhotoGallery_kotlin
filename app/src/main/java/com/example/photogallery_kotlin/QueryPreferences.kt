package com.example.photogallery_kotlin

import android.content.Context
import android.preference.PreferenceManager
import android.provider.Settings.Global.putString
import androidx.core.content.edit

private const val PREF_SEARCH_QUERY = "searchQuery"

class QueryPreferences {
    fun getStoredQuery(context: Context): String{
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        return prefs.getString(PREF_SEARCH_QUERY, "")!!
    }

    fun setStoredQuery(context: Context, query: String){
        PreferenceManager.getDefaultSharedPreferences(context).edit {
            putString(PREF_SEARCH_QUERY,query)
        }

    }
}