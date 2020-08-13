package com.mubaracktahir.ebirapeople.UI.Entertainment.Photographers

import com.mubaracktahir.ebirapeople.R
import com.mubaracktahir.ebirapeople.UI.Entertainment.EntertainmentFragmentDirections
import com.mubaracktahir.ebirapeople.core.BaseListFragment
import com.mubaracktahir.ebirapeople.databinding.FragmentListBinding
import com.mubaracktahir.ebirapeople.models.People


/**
 * Created by Mubarak Tahir on 8/13/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */
class PhotographyFragment :  BaseListFragment<FragmentListBinding>() {
    override fun handleItemClick(_person: People, pos: Int) {
        navigate(
            PhotographyFragmentDirections.actionPhotographyFragmentToPersonFragment(_person)
        )

    }

    override fun addList() {
        mList.add(People(passString(R.string.ph1),passString(R.string.ph1_d),R.drawable.photograhy))
        mList.add(People(passString(R.string.ph2),passString(R.string.ph2_d),R.drawable.ph2))
        mList.add(People(passString(R.string.ph3),passString(R.string.ph3_d),R.drawable.ph3i))

    }

}