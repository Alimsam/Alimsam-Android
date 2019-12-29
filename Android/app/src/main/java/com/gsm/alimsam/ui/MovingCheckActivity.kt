package com.gsm.alimsam.ui

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.gsm.alimsam.R
import com.gsm.alimsam.ui.manager.Moving
import com.gsm.alimsam.ui.manager.MovingAdapter
import com.gsm.alimsam.utils.DataSingleton
import kotlinx.android.synthetic.main.activity_moving_check.*
import kotlinx.android.synthetic.main.title_bar.*

class MovingCheckActivity : AppCompatActivity() {

    private var movingList = arrayListOf<Moving>(
        Moving("임태건", "2-4반"),
        Moving("임태건", "2-4반"),
        Moving("임태건", "2-4반"),
        Moving("임태건", "2-4반"),
        Moving("임태건", "2-4반"),
        Moving("임태건", "2-4반"),
        Moving("임태건", "2-4반"),
        Moving("임태건", "2-4반"),
        Moving("임태건", "2-4반"),
        Moving("임태건", "2-4반"),
        Moving("임태건", "2-4반"),
        Moving("임태건", "2-4반"),
        Moving("임태건", "2-4반"),
        Moving("임태건", "2-4반"),
        Moving("임태건", "2-4반"),
        Moving("임태건", "2-4반"),
        Moving("임태건", "2-4반"),
        Moving("임태건", "2-4반"),
        Moving("임태건", "2-4반"),
        Moving("임태건", "2-4반")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        overridePendingTransition(R.anim.fade_out, R.anim.no_animation)
        setContentView(R.layout.activity_moving_check)
        init()
        getMovingInfo()
        backButton.setOnClickListener { finish(); overridePendingTransition(R.anim.fade_out, R.anim.fade_in) }
    }

    private fun getMovingInfo() {
        moving_listview.adapter?.notifyDataSetChanged()
        val movingAdapter = MovingAdapter(this, movingList)
        moving_listview.adapter = movingAdapter
    }

    fun init() {
        titleName.text = "이동현황"
        moving_gradeName.text = DataSingleton.getInstance()?.studentGrade
        moving_className.text = DataSingleton.getInstance()?.studentClass
        selectClassAndGradeButton.isVisible = false
    }

    override fun onBackPressed() { super.onBackPressed(); overridePendingTransition(R.anim.fade_out, R.anim.fade_in) }
}
