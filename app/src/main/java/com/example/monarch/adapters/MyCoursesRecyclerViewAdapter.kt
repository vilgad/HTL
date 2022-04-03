package com.example.monarch.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.monarch.R
import com.example.monarch.dataClasses.SearchItems
import com.example.monarch.databinding.CurrentCourseViewBinding

class MyCoursesRecyclerViewAdapter(
    private val list: List<SearchItems>
): RecyclerView.Adapter<MyCoursesRecyclerViewAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: CurrentCourseViewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.current_course_view, parent, false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(val binding: CurrentCourseViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SearchItems) {
            binding.tvCurrentCourseName.text = item.snippet.title
            binding.tvCurrentCourseAuthor.text = item.snippet.channelTitle
            Glide.with(binding.root).load(item.snippet.thumbnails.default.url).into(binding.ivCurrentCourseBanner)
        }
    }
}