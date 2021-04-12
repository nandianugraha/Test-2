package com.nandia.test2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nandia.test2.ui.main.DummyFragment
import com.nandia.test2.ui.watchlist.WatchlistFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_watchlist -> {
                    loadWatchlistFragment(savedInstanceState)
                    supportActionBar?.title = getString(R.string.watchlist)
                }
                R.id.navigation_stream -> {
                    loadDummyFragment(savedInstanceState)
                    supportActionBar?.title = getString(R.string.stream)
                    DummyFragment.title = getString(R.string.stream)
                }
                R.id.navigation_search -> {
                    loadDummyFragment(savedInstanceState)
                    supportActionBar?.title = getString(R.string.search)
                    DummyFragment.title = getString(R.string.search)
                }
                R.id.navigation_chat -> {
                    loadDummyFragment(savedInstanceState)
                    supportActionBar?.title = getString(R.string.chat)
                    DummyFragment.title = getString(R.string.chat)
                }
                R.id.navigation_portofolio -> {
                    loadDummyFragment(savedInstanceState)
                    supportActionBar?.title = getString(R.string.portofolio)
                    DummyFragment.title = getString(R.string.portofolio)
                }
            }
            true
        }
        bottom_navigation.selectedItemId = R.id.navigation_watchlist
    }

    private fun loadWatchlistFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, WatchlistFragment(), WatchlistFragment::class.java.simpleName)
                .commit()
        }
    }

    private fun loadDummyFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, DummyFragment(), DummyFragment::class.java.simpleName)
                .commit()
        }
    }
}