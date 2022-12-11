package com.example.commercial_app

import androidx.appcompat.widget.Toolbar
import android.os.Bundle
import android.telecom.Call
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import retrofit2.Response
import javax.security.auth.callback.Callback

class PopFragment : Fragment(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var navigationView: NavigationView
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toolbar: Toolbar

    private lateinit var adapter: RankingAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var rankingList: List<RankingData>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?

    ): View? {

        callProductInfo()

        val view = inflater.inflate(R.layout.fragment_pop, container, false)

        toolbar = view.findViewById(R.id.pf_toolbar) // toolBar를 통해 App Bar 생성

        (activity as AppCompatActivity).setSupportActionBar(toolbar) // 툴바 적용

        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true) // 드로어를 꺼낼 홈 버튼 활성화
        (activity as AppCompatActivity).supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_drawable) // 홈버튼 이미지 변경
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowTitleEnabled(false) // 툴바에 타이틀 안보이게

        // 네비게이션 드로어 생성
        drawerLayout = view.findViewById(R.id.pf_drawer_layout)
        // 네비게이션 드로어 내에있는 화면의 이벤트를 처리하기 위해 생성
        navigationView = view.findViewById(R.id.pf_nav_view)
        navigationView.setNavigationItemSelectedListener(this) //navigation 리스너

        // 드로우네이아웃 선택 시 표시하는거?
        toolbar.setNavigationOnClickListener{
            drawerLayout.openDrawer(GravityCompat.START)
        }

        //ranking list 세팅
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.ranking_recyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)

        return view
    }


    // 드로어 내 아이템 클릭 이벤트 처리하는 함수
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.menu_item1 -> {
                true
            }
            R.id.menu_item2 -> {
                true
            }
            R.id.menu_item3 -> {
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun callProductInfo(){

        val call = ApiObject.getProductInfo.getProductInfoAll(shopName = "GS")
        call.enqueue(object: retrofit2.Callback<List<RankingData>> {

            override fun onResponse(call: retrofit2.Call<List<RankingData>>, response: Response<List<RankingData>>) {
                val tag = "OnResponse : "
                Log.d(tag, "호출 성공함")

                if(response.isSuccessful) {
                    rankingList = response.body() ?: listOf()
                    val tag = "ProductData : "
                    Log.d(tag, rankingList.toString())

                    getRankingList()


                }
            }

            override fun onFailure(call: retrofit2.Call<List<RankingData>>, t: Throwable) {

                val tag = "OnResponse : "
                Log.d(tag, "실패함")
            }
        })

    }

    private fun getRankingList(){

        adapter = RankingAdapter(rankingList as MutableList<RankingData>)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

    }
}