package com.example.monarch.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.monarch.dataClasses.Course
import com.example.monarch.R
import com.example.monarch.databinding.CourseViewBinding

class CoursesRecyclerViewAdapter(
    private val list: List<Course>
) : RecyclerView.Adapter<CoursesRecyclerViewAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: CourseViewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.course_view, parent, false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(val binding: CourseViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Course) {
            binding.ivCourseBanner.setImageResource(R.drawable._458571)
            binding.tvCourseName.text = item.name
            binding.tvCourseAuthor.text = item.author
            binding.tvViews.text = item.views
        }
    }
}