package com.gsm.alimsam.utils

import android.content.Context
import android.net.ConnectivityManager

class NetworkUtils {
    fun checkNetworkConnected(context: Context): Boolean {

        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo?: null

        return networkInfo != null && networkInfo.isConnected
    }
}