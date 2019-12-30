package com.gsm.alimsam.manager

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitHelper {
    @GET("outing/getOutingList?")
    fun getOutingData(@Query("date") dateInfo: String, @Query("class") studentInfo: String): Observable<ArrayList<Outing>>

    @GET("moving/getMovingList/?")
    fun getMovingData(@Query("date") dateInfo: String, @Query("class") studentInfo: String): Observable<ArrayList<Moving>>
}