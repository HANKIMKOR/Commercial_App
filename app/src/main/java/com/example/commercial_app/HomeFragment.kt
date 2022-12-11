package com.example.commercial_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    private lateinit var rankingAdapter: RankingAdapter
    private lateinit var recyclerView: RecyclerView
    private var rankingArrayList = ArrayList<RankingData>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecycler()

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_ranking_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        rankingAdapter = RankingAdapter(rankingArrayList)
        recyclerView.adapter = rankingAdapter
    }

    private fun initRecycler() {

        rankingArrayList = arrayListOf(
            RankingData(
                img = R.drawable.product_img_01,
                name = getString(R.string.name_1),
                price = getString(R.string.price_1)
            ),
            RankingData(
                img = R.drawable.product_img_02,
                name = getString(R.string.name_2),
                price = getString(R.string.price_2)
            ),
            RankingData(
                img = R.drawable.product_img_03,
                name = getString(R.string.name_3),
                price = getString(R.string.price_3)
            )
        )
    }
}