package com.example.monarch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.monarch.databinding.CategeoryViewBinding
import com.example.monarch.databinding.CourseViewBinding

class CategeoryRecyclerViewAdapter(
    val list: List<String>
) : RecyclerView.Adapter<CategeoryRecyclerViewAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: CategeoryViewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.categeory_view, parent, false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(val binding: CategeoryViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.tvCategory.text = item
        }
    }
}