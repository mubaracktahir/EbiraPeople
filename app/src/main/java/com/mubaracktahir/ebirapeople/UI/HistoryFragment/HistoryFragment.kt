package com.mubaracktahir.ebirapeople.UI.HistoryFragment

import androidx.navigation.findNavController
import com.mubaracktahir.ebirapeople.R
import com.mubaracktahir.ebirapeople.core.FullScreenFragment
import com.mubaracktahir.ebirapeople.databinding.FragmentHistoryBinding


class HistoryFragment : FullScreenFragment<FragmentHistoryBinding>(R.layout.fragment_history){
    override fun init() {
        binding.fabs.setOnClickListener {
            view?.findNavController()?.popBackStack()
        }
    }
}