package com.gsm.alimsam.ui

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gsm.alimsam.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        overridePendingTransition(R.anim.fade_out, R.anim.no_animation)
        setContentView(R.layout.activity_main)

        moving_button.setOnClickListener { startActivity(Intent(this, MovingSelectClassActivity::class.java)) }

        outing_button.setOnClickListener { startActivity(Intent(this, OutingSelectClassActivity::class.java)) }
    }
}
