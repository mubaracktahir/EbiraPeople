package com.mubaracktahir.ebirapeople.UI.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mubaracktahir.ebirapeople.R
import com.mubaracktahir.ebirapeople.core.BaseFragment
import com.mubaracktahir.ebirapeople.databinding.FragmentHomeBinding

/**
 * This is the Fragment that is Shown after the [SplashScreenFragment]
 *
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    override fun init() {
        setUpWidget()
    }

    /**
     * Setting up the UI component of [HomeFragment]
     * listening to clicks and scrolls from Views are in this Function
     *
     */
    fun setUpWidget() {
        binding.historyCard.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToHistoryFragment())
        }
        binding.cultureCard.setOnClickListener {

        }
        binding.peopleCard.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToPeopleFragment())

        }
        binding.entertainmentCard.setOnClickListener {

        }

    }

}