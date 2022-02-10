package com.example.monarch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.monarch.databinding.CurrentCourseViewBinding
import com.example.monarch.databinding.FragmentMyCoursesBinding
import com.google.android.material.tabs.TabLayoutMediator

class MyCoursesFragment : Fragment() {
    private lateinit var binding: FragmentMyCoursesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_my_courses, container, false)

        val adapter = MyCoursesVPAdapter(requireActivity().supportFragmentManager,lifecycle)
        binding.viewPagerMyCourses.adapter = adapter

        TabLayoutMediator(binding.tabLayoutMyCourses,binding.viewPagerMyCourses) {
            tab,position -> when(position) {
                0 -> tab.text = "Ongoing"
                1 -> tab.text = "Completed"
            }
        }.attach()
        // Inflate the layout for this fragment
        return binding.root
    }
}