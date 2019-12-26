package com.gsm.alimsam.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.gsm.alimsam.R
import kotlinx.android.synthetic.main.title_bar.*

class MovingCheckActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.fade_out, R.anim.no_animation)
        setContentView(R.layout.activity_moving_check)
        titleName.setText("이동현황")
        selectClassAndGradeButton.isVisible = false
        backButton.setOnClickListener { finish(); overridePendingTransition(R.anim.fade_out, R.anim.no_animation) }
    }
}
