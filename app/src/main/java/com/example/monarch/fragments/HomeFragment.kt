package com.example.monarch.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.monarch.adapters.CategeoryRecyclerViewAdapter
import com.example.monarch.dataClasses.Course
import com.example.monarch.adapters.CoursesRecyclerViewAdapter
import com.example.monarch.R
import com.example.monarch.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var coursesRecyclerViewAdapter: CoursesRecyclerViewAdapter
    private lateinit var categeoryRecyclerViewAdapter: CategeoryRecyclerViewAdapter

    val lst: List<Course> = listOf(
        Course("Web Development", "CodeWithHarry", "2.5 lakh"),
        Course("MVVM Series", "FoxAndroid", "35k"),
        Course("Android Development", "Cheezy Code", "25 million"),
        Course("Flutter - One Video", "Apna College", "2 crore")
    )
    val categ: List<String> =
        listOf("Development", "Cooking", "Personal Growth", "Finance", "Teaching")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_home, container, false)

        // course recycler view
        binding.courseRecyclerView.setHasFixedSize(true)
        val linearLayoutManager1: RecyclerView.LayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.courseRecyclerView.layoutManager = linearLayoutManager1

        coursesRecyclerViewAdapter = CoursesRecyclerViewAdapter((lst))
        binding.courseRecyclerView.adapter = coursesRecyclerViewAdapter

        // category recycler view
        val linearLayoutManager2: RecyclerView.LayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.categoryRecyclerView.layoutManager = linearLayoutManager2

        categeoryRecyclerViewAdapter = CategeoryRecyclerViewAdapter(categ)
        binding.categoryRecyclerView.adapter = categeoryRecyclerViewAdapter

        binding.ivCurrentCourseBannerHome.setImageResource(R.drawable._458571)
        binding.tvCurrentCourseNameHome.text = lst[0].name
        binding.tvCurrentCourseAuthorHome.text = lst[0].author
        // Inflate the layout for this fragment
        return binding.root
    }
}