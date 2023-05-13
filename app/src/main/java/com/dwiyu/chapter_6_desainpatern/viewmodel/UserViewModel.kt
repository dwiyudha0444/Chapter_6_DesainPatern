package com.dwiyu.chapter_6_desainpatern.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dwiyu.chapter_6_desainpatern.model.ResponseDataUserItem
import com.dwiyu.chapter_6_desainpatern.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel(
    val application: Application
    ): AndroidViewModel(application){
        val user = MutableLiveData<List<ResponseDataUserItem>>()

        fun getLiveDataUser():MutableLiveData<List<ResponseDataUserItem>>{
            return user
        }

        fun getAllUser(){
            ApiClient.instance.getAllUser().enqueue(object : Callback<List<ResponseDataUserItem>>{
                override fun onResponse(
                    call: Call<List<ResponseDataUserItem>>,
                    response: Response<List<ResponseDataUserItem>>
                ) {
                    if (response.isSuccessful){
                        user.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<List<ResponseDataUserItem>>, t: Throwable) {
                    Toast.makeText(getApplication(),t.message, Toast.LENGTH_SHORT).show()
                }
            })
        }
    }