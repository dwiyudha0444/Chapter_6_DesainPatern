package com.dwiyu.chapter_6_desainpatern.view

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dwiyu.chapter_6_desainpatern.R
import com.dwiyu.chapter_6_desainpatern.databinding.ActivityMainBinding
import com.dwiyu.chapter_6_desainpatern.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var userAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setVmAdapter()
    }
    fun setVmAdapter(){
        val viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        viewModel.getLiveDataUser().observe(this, Observer {
            userAdapter= UserAdapter(it)
            val layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
            binding.rvHome.layoutManager=layoutManager
            binding.rvHome.adapter=userAdapter
        })
    }
}