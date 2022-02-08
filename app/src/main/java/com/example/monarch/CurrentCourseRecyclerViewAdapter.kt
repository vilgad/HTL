package com.example.monarch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.monarch.databinding.CurrentCourseViewBinding

class CurrentCourseRecyclerViewAdapter(
    val course: Course
) : RecyclerView.Adapter<CurrentCourseRecyclerViewAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: CurrentCourseViewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.current_course_view, parent, false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(course)
    }

    override fun getItemCount(): Int {
        return 1
    }

    class MyViewHolder(val binding: CurrentCourseViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Course) {
            binding.tvCurrentCourseName.text = item.name
            binding.ivCurrentCourseBanner.setImageResource(R.drawable._458571)
        }
    }
}