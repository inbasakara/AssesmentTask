package com.wiprotask.telstra.repository

import com.wiprotask.telstra.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {
    fun getAllFact() = retrofitService.getAllFactList()
}