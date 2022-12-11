package com.example.commercial_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.commercial_app.databinding.ActivityNaviBinding

private const val TAG_POP = "pop_fragment"
private const val TAG_HOME = "home_fragment"
private const val TAG_SEARCH = "search_fragment"

class NaviActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNaviBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNaviBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setFragment(TAG_HOME, HomeFragment())

        binding.navigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.popFragment -> setFragment(TAG_POP, PopFragment())
                R.id.homeFragment -> setFragment(TAG_HOME, HomeFragment())
                R.id.searchFragment-> setFragment(TAG_SEARCH, SearchFragment())
            }
            true
        }
    }

    private fun setFragment(tag: String, fragment: Fragment) {
        val manager: FragmentManager = supportFragmentManager
        val fragTransaction = manager.beginTransaction()

        if (manager.findFragmentByTag(tag) == null){
            fragTransaction.add(R.id.mainFrameLayout, fragment, tag)
        }

        val pop = manager.findFragmentByTag(TAG_POP)
        val home = manager.findFragmentByTag(TAG_HOME)
        val search = manager.findFragmentByTag(TAG_SEARCH)

        if (pop != null){
            fragTransaction.hide(pop)
        }

        if (home != null){
            fragTransaction.hide(home)
        }

        if (search != null) {
            fragTransaction.hide(search)
        }

        if (tag == TAG_POP) {
            if (pop != null){
                fragTransaction.show(pop)
            }
        }
        else if (tag == TAG_HOME) {
            if (home != null) {
                fragTransaction.show(home)
            }
        }

        else if (tag == TAG_SEARCH){
            if (search != null){
                fragTransaction.show(search)
            }
        }

        fragTransaction.commitAllowingStateLoss()
    }
}