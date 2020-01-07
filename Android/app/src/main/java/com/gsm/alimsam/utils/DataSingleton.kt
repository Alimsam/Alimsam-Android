package com.gsm.alimsam.utils

class DataSingleton {

    var studentGrade: String? = null
    var studentClass: String? = null
    var getDate: String? = DateUtil.getToday()

    companion object {
        private var instance: DataSingleton? = null

        fun getInstance(): DataSingleton? {
            if (instance == null) instance = DataSingleton()

            return instance
        }

        fun getStudentGradeForRetrofit(): String {
            return when(getInstance()?.studentGrade) {
                "1학년" -> return "1"
                "2학년" -> return "2"
                "3학년" -> return "3"
                else -> ""
            }
        }

        fun getStucentClassForRetrofit(): String {
            return when(getInstance()?.studentClass) {
                "1반" -> return "1"
                "2반" -> return "2"
                "3반" -> return "3"
                "4반" -> return "4"
                else -> ""
            }
        }
    }
}