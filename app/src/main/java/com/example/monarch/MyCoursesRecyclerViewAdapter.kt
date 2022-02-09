package com.example.monarch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.monarch.databinding.CurrentCourseViewBinding

class MyCoursesRecyclerViewAdapter(
    private val list: List<Course>
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
        fun bind(item: Course) {
            binding.tvCurrentCourseName.text = item.name
            binding.tvCurrentCourseAuthor.text = item.author
            binding.ivCurrentCourseBanner.setImageResource(R.drawable._458571)
        }
    }
}