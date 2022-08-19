package com.wiprotask.telstra

import com.wiprotask.telstra.model.FactList
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("facts.json")
    fun getAllFactList(): Call<FactList>
    companion object {
        var retrofitService: RetrofitService? = null
        val baseurl : String ="https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/"
        fun getInstance(): RetrofitService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(baseurl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}