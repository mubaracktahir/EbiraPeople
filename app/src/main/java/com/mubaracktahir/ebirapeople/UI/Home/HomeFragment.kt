package com.mubaracktahir.ebirapeople.UI.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mubaracktahir.ebirapeople.R
import com.mubaracktahir.ebirapeople.databinding.FragmentHomeBinding

/**
 * This is the Fragment that is Shown after the [SplashScreenFragment]
 *
 */
class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        setUpWidget()
        return binding.root
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