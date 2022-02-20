package com.example.monarch

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.monarch.databinding.FragmentOnGoingCoursesBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OnGoingCoursesFragment : Fragment() {
    private var PAGE_TOKEN = "CAUQAQ"
    private lateinit var binding: FragmentOnGoingCoursesBinding
    private lateinit var myCoursesRecyclerViewAdapter: MyCoursesRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_on_going_courses, container, false)

        val linearLayoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.onGoingCoursesRV.layoutManager = linearLayoutManager

        getPlaylists()

        binding.btNextCourse.setOnClickListener { getPlaylists() }
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun getPlaylists() {
        val playlist = SearchService.searchInstance.getPlaylists("Development",PAGE_TOKEN)
        playlist.enqueue(object : Callback<SearchPlaylists> {
            override fun onResponse(call: Call<SearchPlaylists>, response: Response<SearchPlaylists>) {
                val playl = response.body()
                Log.d("Vilgad",playl.toString())
                myCoursesRecyclerViewAdapter = MyCoursesRecyclerViewAdapter(playl!!.items)
                binding.onGoingCoursesRV.adapter = myCoursesRecyclerViewAdapter
                PAGE_TOKEN = playl.nextPageToken
            }

            override fun onFailure(call: Call<SearchPlaylists>, t: Throwable) {
                Log.d("Vilgad","Error in fetching playlists")
            }
        })
    }
}