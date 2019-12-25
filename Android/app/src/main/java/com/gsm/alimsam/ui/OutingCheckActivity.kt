package com.gsm.alimsam.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gsm.alimsam.R

class OutingCheckActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        setContentView(R.layout.activity_outing_check)
    }
}
