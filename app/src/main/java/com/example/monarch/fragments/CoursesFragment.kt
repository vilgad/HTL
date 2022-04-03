package com.example.monarch.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.monarch.dataClasses.Course
import com.example.monarch.adapters.CoursesRecyclerViewAdapter
import com.example.monarch.R
import com.example.monarch.databinding.FragmentCoursesBinding

class CoursesFragment : Fragment() {
    private lateinit var binding: FragmentCoursesBinding

    val lst: List<Course> = listOf(
        Course("Web Development", "CodeWithHarry", "2.5 lakh"),
        Course("MVVM Series", "FoxAndroid", "35k"),
        Course("Android Development", "Cheezy Code", "25 million"),
        Course("Flutter - One Video", "Apna College", "2 crore"),
        Course("Web Development", "CodeWithHarry", "2.5 lakh"),
        Course("MVVM Series", "FoxAndroid", "35k"),
        Course("Android Development", "Cheezy Code", "25 million"),
        Course("Flutter - One Video", "Apna College", "2 crore"),
        Course("Web Development", "CodeWithHarry", "2.5 lakh"),
        Course("MVVM Series", "FoxAndroid", "35k"),
        Course("Android Development", "Cheezy Code", "25 million"),
        Course("Flutter - One Video", "Apna College", "2 crore")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_courses, container, false)
        binding.btSortCourses.setOnClickListener { showMenu() }

        binding.coursesRV.setHasFixedSize(true)
        val gridLayoutManager: RecyclerView.LayoutManager = GridLayoutManager(requireContext(), 2)
        binding.coursesRV.layoutManager = gridLayoutManager

        binding.coursesRV.adapter = CoursesRecyclerViewAdapter(lst)
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun showMenu() {
        val popMenu = PopupMenu(requireContext(), binding.btSortCourses)
        popMenu.menuInflater.inflate(R.menu.bottom_nav_menu, popMenu.menu)
        popMenu.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener {
            override fun onMenuItemClick(p0: MenuItem?): Boolean {
                when (p0!!.itemId) {
                    R.id.homeFragment -> Toast.makeText(
                        requireContext(),
                        "Home fragment",
                        Toast.LENGTH_SHORT
                    ).show()
                    R.id.myCoursesFragment -> Toast.makeText(
                        requireContext(),
                        "Courses fragment",
                        Toast.LENGTH_SHORT
                    ).show()
                    R.id.coursesFragment -> Toast.makeText(
                        requireContext(),
                        "favourites fragment",
                        Toast.LENGTH_SHORT
                    ).show()
                    else -> Toast.makeText(requireContext(), "Profile fragment", Toast.LENGTH_SHORT)
                        .show()
                }
                return true
            }
        })
        popMenu.show()
    }
}