package com.gsm.alimsam.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gsm.alimsam.R

class MovingCheckActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        setContentView(R.layout.activity_moving_check)
    }
}
