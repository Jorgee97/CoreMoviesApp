package com.coreman.moviesmvp.ui.main

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.coreman.moviesmvp.R
import com.coreman.moviesmvp.ui.favorites.FavoriteMoviesFragment
import com.coreman.moviesmvp.ui.popular.PopularMoviesFragment

class ViewPagerAdapter constructor(private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> PopularMoviesFragment()
            else -> FavoriteMoviesFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> context.getString(R.string.popular_movies_title)
            else -> context.getString(R.string.favorite_movies_title)
        }
    }
}