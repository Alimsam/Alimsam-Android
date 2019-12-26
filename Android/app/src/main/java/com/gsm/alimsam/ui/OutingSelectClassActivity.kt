package com.gsm.alimsam.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.gsm.alimsam.R
import com.gsm.alimsam.utils.DataSingleton
import kotlinx.android.synthetic.main.activity_outing_select_class.*
import kotlinx.android.synthetic.main.select_grade_dialog.*
import kotlinx.android.synthetic.main.title_bar.*

class OutingSelectClassActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.fade_out, R.anim.no_animation)
        setContentView(R.layout.activity_outing_select_class)

        titleName.setText("저녁외출")
        backButton.setOnClickListener { finish(); overridePendingTransition(R.anim.fade_out, R.anim.no_animation) }
        selectClassAndGradeButton.setOnClickListener {

            val dialog = BottomSheetDialog(this)
            val bottomSheet = layoutInflater.inflate(R.layout.select_grade_dialog, null)
            dialog.setContentView(bottomSheet)
            dialog.show()

            dialog.grade_one.setOnClickListener { outing_gradeName.setText("1학년"); dialog.dismiss() }
            dialog.grade_two.setOnClickListener { outing_gradeName.setText("2학년"); dialog.dismiss() }
            dialog.grade_three.setOnClickListener { outing_gradeName.setText("3학년"); dialog.cancel() }
        }

        outing_class_one.setOnClickListener(onClickListener)
        outing_class_two.setOnClickListener(onClickListener)
        outing_class_three.setOnClickListener(onClickListener)
        outing_class_four.setOnClickListener(onClickListener)
    }

    private val onClickListener = View.OnClickListener { view ->

        when(view.id) {
            R.id.outing_class_one -> DataSingleton.getInstance()?.studentClass = "1반"
            R.id.outing_class_two -> DataSingleton.getInstance()?.studentClass = "2반"
            R.id.outing_class_three -> DataSingleton.getInstance()?.studentClass = "3반"
            R.id.outing_class_four -> DataSingleton.getInstance()?.studentClass = "4반"
        }

        DataSingleton.getInstance()?.studentGrade = outing_gradeName.text.toString()
        startActivity(Intent(this, OutingCheckActivity::class.java))
    }

    override fun onBackPressed() { super.onBackPressed(); overridePendingTransition(R.anim.fade_out, R.anim.no_animation) }
}
