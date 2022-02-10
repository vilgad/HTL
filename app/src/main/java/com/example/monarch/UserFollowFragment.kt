package com.example.monarch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.monarch.databinding.FragmentUserFollowBinding

class UserFollowFragment : Fragment() {
    private lateinit var binding: FragmentUserFollowBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_user_follow, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }
}