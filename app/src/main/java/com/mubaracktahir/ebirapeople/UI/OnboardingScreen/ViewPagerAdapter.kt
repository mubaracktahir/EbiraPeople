package com.mubaracktahir.ebirapeople.UI.OnboardingScreen

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mubaracktahir.ebirapeople.core.BaseFragment


/**
 * Created by Mubarak Tahir on 7/31/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */
class ViewPagerAdapter(val list: ArrayList<Fragment>, fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle) {
    override fun getItemCount() = list.size
    override fun createFragment(position: Int): Fragment {
        return list[position]
    }
}