package com.gsm.alimsam.ui

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.gsm.alimsam.R
import com.gsm.alimsam.manager.Moving
import com.gsm.alimsam.manager.MovingAdapter
import com.gsm.alimsam.manager.Retrofit
import com.gsm.alimsam.utils.DataSingleton
import com.gsm.alimsam.utils.DateUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_moving_check.*
import kotlinx.android.synthetic.main.title_bar.*

class MovingCheckActivity : AppCompatActivity() {

    private val retrofit by lazy { Retrofit.create() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        overridePendingTransition(R.anim.fade_out, R.anim.no_animation)
        setContentView(R.layout.activity_moving_check)
        init()
        getData()
        backButton.setOnClickListener { finish(); overridePendingTransition(R.anim.fade_out, R.anim.fade_in) }

        moving_swipeRefreshLayout.setOnRefreshListener {
            moving_swipeRefreshLayout.postDelayed({ moving_swipeRefreshLayout.setRefreshing(false) }, 500)
            getData()
        }
        
    }

    private fun getData() {
        retrofit.getMovingData(DateUtil.getToday(),DataSingleton.getStudentGradeForRetrofit() + DataSingleton.getStucentClassForRetrofit())
            .observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
            .subscribe({
                setRecyclerView(it)
            }, {})
    }

    private fun setRecyclerView(it: ArrayList<Moving>?) {
        moving_listview.adapter?.notifyDataSetChanged()
        val movingAdapter = MovingAdapter(this, it!!)
        moving_listview.adapter = movingAdapter
    }

    private fun init() {
        titleName.text = "이동현황"
        moving_gradeName.text = DataSingleton.getInstance()?.studentGrade
        moving_className.text = DataSingleton.getInstance()?.studentClass
        selectClassAndGradeButton.isVisible = false
    }

    override fun onBackPressed() { super.onBackPressed(); overridePendingTransition(R.anim.fade_out, R.anim.fade_in) }
}
