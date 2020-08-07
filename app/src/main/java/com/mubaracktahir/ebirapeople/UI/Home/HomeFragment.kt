package com.mubaracktahir.ebirapeople.UI.Home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mubaracktahir.ebirapeople.R
import com.mubaracktahir.ebirapeople.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        setupWidget()

        return binding.root
    }

    fun setupWidget(){
        binding.historyCard.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_historyFragment)
        }
        binding.cultureCard.setOnClickListener{

        }
        binding.peopleCard.setOnClickListener{

        }
        binding.entertainmentCard.setOnClickListener{

        }

    }

}