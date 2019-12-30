package com.gsm.alimsam.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*


class DateUtil {
    companion object {

        @SuppressLint("SimpleDateFormat")
        private var formatter = SimpleDateFormat("yyyy-MM-dd")
        private var calendar = Calendar.getInstance()
        private var day = calendar.get(Calendar.DAY_OF_WEEK)

        // 함수 호출마다 -1 되는 경우 수정해야됨
        fun getYesterday(): String {
            calendar.add(Calendar.DATE, -1)
            return formatter.format(calendar.time)
        }

        fun getToday(): String = formatter.format(calendar.time)

        fun getDay(): String {
            return when (day) {
                0 -> "토"
                1 -> "일"
                2 -> "월"
                3 -> "화"
                4 -> "수"
                5 -> "목"
                6 -> "금"
                else -> ""
            }
        }

    }
}