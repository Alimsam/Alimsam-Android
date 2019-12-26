package com.gsm.alimsam.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.gsm.alimsam.R
import com.gsm.alimsam.ui.manager.Moving
import com.gsm.alimsam.ui.manager.Outing
import com.gsm.alimsam.ui.manager.OutingAdapter
import com.gsm.alimsam.utils.DataSingleton
import kotlinx.android.synthetic.main.activity_outing_check.*
import kotlinx.android.synthetic.main.title_bar.*

class OutingCheckActivity : AppCompatActivity() {

    private var outingList = arrayListOf<Outing>(
        Outing("임태건", "O"),
        Outing("임태건", "O"),
        Outing("임태건", "X"),
        Outing("임태건", "O"),
        Outing("임태건", "X"),
        Outing("임태건", "O"),
        Outing("임태건", "O"),
        Outing("임태건", "O"),
        Outing("임태건", "X"),
        Outing("임태건", "O"),
        Outing("임태건", "O"),
        Outing("임태건", "O"),
        Outing("임태건", "O"),
        Outing("임태건", "O"),
        Outing("임태건", "X"),
        Outing("임태건", "O"),
        Outing("임태건", "O"),
        Outing("임태건", "X"),
        Outing("임태건", "X"),
        Outing("임태건", "O")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.fade_out, R.anim.no_animation)
        setContentView(R.layout.activity_outing_check)
        init()
        getOutingInfo()
        backButton.setOnClickListener { finish(); overridePendingTransition(R.anim.fade_out, R.anim.no_animation) }
    }

    private fun getOutingInfo() {
        outing_listview.adapter?.notifyDataSetChanged()
        val movingAdapter = OutingAdapter(this, outingList)
        outing_listview.adapter = movingAdapter
    }

    fun init() {
        titleName.setText("외출현황")
        outing_gradeName.text = DataSingleton.getInstance()?.studentGrade
        outing_className.text = DataSingleton.getInstance()?.studentClass
        selectClassAndGradeButton.isVisible = false
    }

    override fun onBackPressed() { super.onBackPressed(); overridePendingTransition(R.anim.fade_out, R.anim.no_animation) }
}
