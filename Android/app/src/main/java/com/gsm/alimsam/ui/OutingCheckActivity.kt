package com.gsm.alimsam.ui

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import com.baoyz.widget.PullRefreshLayout
import com.gsm.alimsam.R
import com.gsm.alimsam.manager.Outing
import com.gsm.alimsam.manager.OutingAdapter
import com.gsm.alimsam.manager.Retrofit
import com.gsm.alimsam.utils.DataSingleton
import com.gsm.alimsam.utils.DateUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_outing_check.*
import kotlinx.android.synthetic.main.title_bar.*
import java.util.*
import kotlin.collections.ArrayList

class OutingCheckActivity : AppCompatActivity() {

    private val retrofit by lazy { Retrofit.create() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        overridePendingTransition(R.anim.fade_out, R.anim.no_animation)
        setContentView(R.layout.activity_outing_check)
        init()
        getData()
        backButton.setOnClickListener { finish(); overridePendingTransition(R.anim.fade_out, R.anim.fade_in) }

        outing_swipeRefreshLayout.setOnRefreshListener {
            outing_swipeRefreshLayout.postDelayed({ outing_swipeRefreshLayout.setRefreshing(false) }, 500)
            getData()
        }

    }

    private fun getData() {
        retrofit.getOutingData(DataSingleton.getInstance()?.getDate!!,DataSingleton.getStudentGradeForRetrofit() + DataSingleton.getStucentClassForRetrofit())
            .observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
            .subscribe({
                setRecyclerView(it)
            }, {})
    }

    private fun setRecyclerView(it: ArrayList<Outing>?) {
        outing_listview.adapter?.notifyDataSetChanged()
        val outingAdapter = OutingAdapter(this, it!!)
        outing_listview.adapter = outingAdapter
    }

    private fun init() {
        titleName.text = "외출현황"
        outing_gradeName.text = DataSingleton.getInstance()?.studentGrade
        outing_className.text = DataSingleton.getInstance()?.studentClass
        selectClassAndGradeButton.isVisible = false
    }

    override fun onBackPressed() { super.onBackPressed(); overridePendingTransition(R.anim.fade_out, R.anim.fade_in) }
}
