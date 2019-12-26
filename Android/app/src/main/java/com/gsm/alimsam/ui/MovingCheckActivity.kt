package com.gsm.alimsam.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.gsm.alimsam.R
import com.gsm.alimsam.utils.DataSingleton
import kotlinx.android.synthetic.main.activity_moving_check.*
import kotlinx.android.synthetic.main.activity_outing_check.*
import kotlinx.android.synthetic.main.title_bar.*

class MovingCheckActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.fade_out, R.anim.no_animation)
        setContentView(R.layout.activity_moving_check)
        init()
        backButton.setOnClickListener { finish(); overridePendingTransition(R.anim.fade_out, R.anim.no_animation) }
    }

    fun init() {
        titleName.setText("이동현황")
        moving_gradeName.text = DataSingleton.getInstance()?.studentGrade
        moving_className.text = DataSingleton.getInstance()?.studentClass
        selectClassAndGradeButton.isVisible = false
    }

    override fun onBackPressed() { super.onBackPressed(); overridePendingTransition(R.anim.fade_out, R.anim.no_animation) }
}
