package com.example.commercial_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup

class HomeFragment : Fragment() {
    var profileAdapter: ProfileAdapter? = null
    private val binding get() = profileAdapter!!
    // lateinit var profileAdapter: ProfileAdapter
    val datas = mutableListOf<ProfileData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    private fun initRecycler() {
        profileAdapter = ProfileAdapter(this)



        datas.apply {
            add(ProfileData(img = R.drawable.ic_pop, name = "mary", age = 24))
            add(ProfileData(img = R.drawable.ic_pop, name = "jenny", age = 26))
            add(ProfileData(img = R.drawable.ic_pop, name = "jhon", age = 27))
            add(ProfileData(img = R.drawable.ic_pop, name = "ruby", age = 21))
            add(ProfileData(img = R.drawable.ic_pop, name = "yuna", age = 23))

            profileAdapter.datas = datas
            profileAdapter.notifyDataSetChanged()

        }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = ProfileAdapter.inflate(layoutInflater)
//        initRecycler()
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)
//    }


    }
}