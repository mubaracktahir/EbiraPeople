package com.mubaracktahir.ebirapeople.UI.PeopleFragment.Person

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.mubaracktahir.ebirapeople.R
import com.mubaracktahir.ebirapeople.core.BaseFragment
import com.mubaracktahir.ebirapeople.core.FullScreenFragment
import com.mubaracktahir.ebirapeople.databinding.FragmentPersonBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [FullScreenFragment] subclass.
 *
 *
 */

class PersonFragment : FullScreenFragment<FragmentPersonBinding>( R.layout.fragment_person) {

    override fun init() {
        val args = PersonFragmentArgs.fromBundle(requireArguments())
        val person = args.person
        binding.person = person
        binding.executePendingBindings()
    }

}