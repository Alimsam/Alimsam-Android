package com.gsm.alimsam.manager

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {
    companion object {
        fun create(): RetrofitHelper {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http://54.180.88.152:3000/").build()

            return retrofit.create(RetrofitHelper::class.java)
        }
    }
}