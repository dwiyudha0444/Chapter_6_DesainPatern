package com.dwiyu.chapter_6_desainpatern.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dwiyu.chapter_6_desainpatern.databinding.ItemUserBinding
import com.dwiyu.chapter_6_desainpatern.model.ResponseDataUserItem

class UserAdapter(var ListUser:List<ResponseDataUserItem>):RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    class ViewHolder(var binding : ItemUserBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        val view = ItemUserBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        holder.binding.tvNama.text = ListUser[position].name
        holder.binding.tvUmur.text = ListUser[position].age.toString()
        holder.binding.tvAlamat.text = ListUser[position].address
    }

    override fun getItemCount(): Int {
        return  ListUser.size
    }
}