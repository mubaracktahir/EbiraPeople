package com.mubaracktahir.ebirapeople.UI.PeopleFragment

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.mubaracktahir.ebirapeople.core.BaseListFragment
import com.mubaracktahir.ebirapeople.R
import com.mubaracktahir.ebirapeople.databinding.FragmentListBinding
import com.mubaracktahir.ebirapeople.databinding.FragmentPersonBinding
import com.mubaracktahir.ebirapeople.models.People

/**
 * A simple [Fragment] subclass.
 *
 */
class PeopleListFragment : BaseListFragment<FragmentListBinding>(R.layout.fragment_list ) {
    override fun handleItemClick(_person: People) {
        findNavController().navigate(PeopleListFragmentDirections.actionPeopleFragmentToPersonFragment(_person))
    }
    override fun addList() {
        mList.add(People(resources.getString(R.string.p2), resources.getString(R.string.p2_d)))
        mList.add(People(resources.getString(R.string.p3), resources.getString(R.string.p3_d)))
        mList.add(People(resources.getString(R.string.p4), resources.getString(R.string.p4_d)))
        mList.add(People(resources.getString(R.string.p5), resources.getString(R.string.p5_d)))
        mList.add(People(resources.getString(R.string.p6), resources.getString(R.string.p6_d),  R.drawable.demo))
        mList.add(People(resources.getString(R.string.p7), resources.getString(R.string.p7_d)))
        mList.add(People(resources.getString(R.string.p8), resources.getString(R.string.p8_d)))
        mList.add(People(resources.getString(R.string.p9), resources.getString(R.string.p9_d)))
        mList.add(People(resources.getString(R.string.p10), resources.getString(R.string.p10_d)))
        mList.add(People(resources.getString(R.string.p11), resources.getString(R.string.p11_d)))
        mList.add(People(resources.getString(R.string.p12), resources.getString(R.string.p12_d)))
        mList.add(People(resources.getString(R.string.p13), resources.getString(R.string.p13_d)))
        mList.add(People(resources.getString(R.string.p14), resources.getString(R.string.p14_d)))
        mList.add(People(resources.getString(R.string.p15), resources.getString(R.string.p15_d)))
    }
}