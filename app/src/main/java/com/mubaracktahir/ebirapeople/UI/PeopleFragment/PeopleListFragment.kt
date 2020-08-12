package com.mubaracktahir.ebirapeople.UI.PeopleFragment

import androidx.fragment.app.Fragment
import com.mubaracktahir.ebirapeople.R
import com.mubaracktahir.ebirapeople.core.BaseListFragment
import com.mubaracktahir.ebirapeople.databinding.FragmentListBinding
import com.mubaracktahir.ebirapeople.models.People

/**
 * A simple [Fragment] subclass.
 *
 */
class PeopleListFragment : BaseListFragment<FragmentListBinding>() {
    override fun handleItemClick(_person: People, pos: Int) {
        navigate(PeopleListFragmentDirections.actionPeopleFragmentToPersonFragment(_person))
    }

    override fun addList() {
        mList.add(
            People(
                resources.getString(R.string.p2),
                resources.getString(R.string.p2_d),
                R.drawable.p2
            )
        )
        mList.add(
            People(
                resources.getString(R.string.p3),
                resources.getString(R.string.p3_d),
                R.drawable.p3
            )
        )
        mList.add(
            People(
                resources.getString(R.string.p4),
                resources.getString(R.string.p4_d),
                R.drawable.p4
            )
        )
        mList.add(
            People(
                resources.getString(R.string.p5),
                resources.getString(R.string.p5_d),
                R.drawable.p5
            )
        )
        mList.add(
            People(
                resources.getString(R.string.p6),
                resources.getString(R.string.p6_d),
                R.drawable.demo
            )
        )
        mList.add(
            People(
                resources.getString(R.string.p7),
                resources.getString(R.string.p7_d),
                R.drawable.p7
            )
        )
        mList.add(
            People(
                resources.getString(R.string.p8),
                resources.getString(R.string.p8_d),
                R.drawable.p8
            )
        )
        mList.add(
            People(
                resources.getString(R.string.p9),
                resources.getString(R.string.p9_d),
                R.drawable.p9
            )
        )
        mList.add(
            People(
                resources.getString(R.string.p10),
                resources.getString(R.string.p10_d),
                R.drawable.p10
            )
        )
        mList.add(
            People(
                resources.getString(R.string.p11),
                resources.getString(R.string.p11_d),
                R.drawable.p11
            )
        )
        mList.add(
            People(
                resources.getString(R.string.p12),
                resources.getString(R.string.p12_d),
                R.drawable.p12
            )
        )
        mList.add(
            People(
                resources.getString(R.string.p13),
                resources.getString(R.string.p13_d),
                R.drawable.p13
            )
        )
        mList.add(
            People(
                resources.getString(R.string.p14),
                resources.getString(R.string.p14_d),
                R.drawable.p14
            )
        )
        mList.add(
            People(
                resources.getString(R.string.p15),
                resources.getString(R.string.p15_d),
                R.drawable.p15
            )
        )
        mList.add(People(resources.getString(R.string.p16), resources.getString(R.string.p16_d)))
        mList.add(People(resources.getString(R.string.p17), resources.getString(R.string.p17_d)))
        mList.add(People(resources.getString(R.string.p18), resources.getString(R.string.p18_d)))
        mList.add(People(resources.getString(R.string.p19), resources.getString(R.string.p19_d)))
        mList.add(People(resources.getString(R.string.p20), resources.getString(R.string.p20_d)))
        mList.add(People(resources.getString(R.string.p21), resources.getString(R.string.p21_d)))
        mList.add(People(resources.getString(R.string.p22), resources.getString(R.string.p22_d)))
        mList.add(People(resources.getString(R.string.p23), resources.getString(R.string.p23_d)))
        mList.add(People(resources.getString(R.string.p24), resources.getString(R.string.p24_d)))
    }
}