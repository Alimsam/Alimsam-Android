package com.gsm.alimsam.ui

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.gsm.alimsam.R
import com.gsm.alimsam.utils.DateUtil
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        overridePendingTransition(R.anim.fade_out, R.anim.no_animation)
        setContentView(R.layout.activity_main)

        for (i in 1..10) {
            Log.d("debug", DateUtil.getYesterday())
        }

        moving_button.setOnClickListener { startActivity(Intent(this, MovingSelectClassActivity::class.java)) }

        outing_button.setOnClickListener { /*if (checkOutingDay())*/ startActivity(Intent(this, OutingSelectClassActivity::class.java)) }
    }

/*
    private fun checkOutingDay(): Boolean {
        if (DateUtil.getDay() == "월" || DateUtil.getDay() == "수") return true
        else Toasty.info(this, "외출일이 아닙니다.", Toast.LENGTH_SHORT, true).show()
        return false
    } */
}
