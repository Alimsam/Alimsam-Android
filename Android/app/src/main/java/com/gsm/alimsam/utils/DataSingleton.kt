package com.gsm.alimsam.utils

class DataSingleton {

    companion object {
        private var instance: DataSingleton? = null

        fun getInstance(): DataSingleton? {
            if (instance == null) instance = DataSingleton()

            return instance
        }

    }

    var studentGrade: String? = null
    var studentClass: String? = null
}