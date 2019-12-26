package com.gsm.alimsam.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gsm.alimsam.R
import kotlinx.android.synthetic.main.title_bar.*

class OutingCheckActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.fade_out, R.anim.no_animation)
        setContentView(R.layout.activity_outing_check)
        titleName.setText("외출현황")
        backButton.setOnClickListener { finish(); overridePendingTransition(R.anim.fade_out, R.anim.no_animation) }
    }
}
