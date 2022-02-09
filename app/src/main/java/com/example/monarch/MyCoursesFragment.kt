package com.example.monarch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.monarch.databinding.CurrentCourseViewBinding
import com.example.monarch.databinding.FragmentMyCoursesBinding

class MyCoursesFragment : Fragment() {
    private lateinit var binding: FragmentMyCoursesBinding
    private lateinit var myCoursesRecyclerViewAdapter: MyCoursesRecyclerViewAdapter

    val lst: List<Course> = listOf(
        Course("Web Development", "CodeWithHarry", "2.5 lakh"),
        Course("MVVM Series", "FoxAndroid", "35k"),
        Course("Android Development", "Cheezy Code", "25 million"),
        Course("Flutter - One Video", "Apna College", "2 crore")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_my_courses, container, false)

        val linearLayoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.myCoursesRecyclerView.layoutManager = linearLayoutManager

        myCoursesRecyclerViewAdapter = MyCoursesRecyclerViewAdapter(lst)
        binding.myCoursesRecyclerView.adapter = myCoursesRecyclerViewAdapter
        // Inflate the layout for this fragment
        return binding.root
    }
}