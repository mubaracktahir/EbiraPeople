package com.mubaracktahir.ebirapeople.UI.PeopleFragment.Person

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.mubaracktahir.ebirapeople.R
import com.mubaracktahir.ebirapeople.core.BaseFragment
import com.mubaracktahir.ebirapeople.core.FullScreenFragment
import com.mubaracktahir.ebirapeople.databinding.FragmentPersonBinding


/**
 * A simple [FullScreenFragment] subclass.
 *
 *
 */

class PersonFragment : FullScreenFragment<FragmentPersonBinding>( R.layout.fragment_person) {

    override fun init() {
        val args = PersonFragmentArgs.fromBundle(requireArguments())
        val person = args.person
        binding.fabs.setOnClickListener {
            //activity?.supportFragmentManager?.popBackStack()
            view?.findNavController()?.popBackStack()
        }
        binding.person = person
        binding.executePendingBindings()
    }

}