package com.example.commercial_app

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SearchFragment : Fragment() {

    private lateinit var searchView: SearchView

    private lateinit var adapter: SearchAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchArrayList: ArrayList<SearchData>
    private lateinit var searchResultArrayList: ArrayList<SearchData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_search, container, false)

        getSearchList()
        getSearchResultList()

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.search_recyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = SearchAdapter(searchResultArrayList)
        recyclerView.adapter = adapter

        val searchViewTextListener: SearchView.OnQueryTextListener =
            object : SearchView.OnQueryTextListener {
                //검색버튼 입력시 호출, 검색버튼이 없으므로 사용하지 않음
                override fun onQueryTextSubmit(qString: String): Boolean {
                    return false
                }

                //텍스트 입력/수정시에 호출
                @SuppressLint("NotifyDataSetChanged")
                override fun onQueryTextChange(qString: String): Boolean {

                    searchResultArrayList.clear()

                    if (qString.isNotEmpty()){

                        searchArrayList.forEach{
                            if(it.name.contains(qString)){

                                searchResultArrayList.add(it)

                                val tag = "onQueryTextChange : "
                                Log.d(tag, it.toString())

                            }
                        }
                    }

                    recyclerView.adapter!!.notifyDataSetChanged()

                    return false
                }
            }

        searchView = view.findViewById(R.id.searchView)
        searchView.setOnClickListener{

            searchView.isIconified = false


        }
        searchView.setOnQueryTextListener(searchViewTextListener)


        // Inflate the layout for this fragment
        return view

    }

    private fun getSearchList(){

        searchArrayList = arrayListOf(
            SearchData(name = getString(R.string.search_name_1), price = getString(R.string.search_price_1)),
            SearchData(name = getString(R.string.search_name_2), price = getString(R.string.search_price_2)),
            SearchData(name = getString(R.string.search_name_3), price = getString(R.string.search_price_3)),
            SearchData(name = getString(R.string.search_name_4), price = getString(R.string.search_price_4)),
            SearchData(name = getString(R.string.search_name_5), price = getString(R.string.search_price_5)),
            SearchData(name = getString(R.string.search_name_6), price = getString(R.string.search_price_6))
        )

    }

    private fun getSearchResultList(){

        searchResultArrayList = arrayListOf()

    }


}