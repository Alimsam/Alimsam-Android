package com.gsm.alimsam.ui.splash

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gsm.alimsam.R
import com.gsm.alimsam.ui.MainActivity
import com.gsm.alimsam.utils.NetworkUtils

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_splash)

        val splash = object : Thread() {
            override fun run() {
                sleep(1500)
                if (NetworkUtils().checkNetworkConnected(applicationContext)) openMainActivity()
            }
        }
        splash.start()
    }

    fun openMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
