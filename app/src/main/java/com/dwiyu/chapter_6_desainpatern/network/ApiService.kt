package com.dwiyu.chapter_6_desainpatern.network

import com.dwiyu.chapter_6_desainpatern.model.ResponseDataUserItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("user")
    fun getAllUser(): Call<List<ResponseDataUserItem>>
}