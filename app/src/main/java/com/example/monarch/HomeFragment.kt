package com.example.monarch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.monarch.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    val lst: List<Course> = listOf(
        Course("Web Development", "CodeWithHarry", "25009463"),
        Course("MVVM Series", "FoxAndroid", "356249"),
        Course("Android Development", "Cheezy Code", "25292484"),
        Course("Flutter - One Video", "Apna College", "25292")
    )
    val categ: List<String> =
        listOf("Development", "Cooking", "Personal Growth", "Finance", "Teaching")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_home, container, false)

        // course recycler view
        // Inflate the layout for this fragment
        return binding.root
    }
}