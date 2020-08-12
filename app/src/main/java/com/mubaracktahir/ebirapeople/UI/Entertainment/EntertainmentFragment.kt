package com.mubaracktahir.ebirapeople.UI.Entertainment

import com.mubaracktahir.ebirapeople.R
import com.mubaracktahir.ebirapeople.core.BaseListFragment
import com.mubaracktahir.ebirapeople.databinding.FragmentListBinding
import com.mubaracktahir.ebirapeople.models.People


/**
 * Created by Mubarak Tahir on 8/12/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */
class EntertainmentFragment : BaseListFragment<FragmentListBinding>() {
    override fun addList() {
        mList.add(
            People(
                "Bloggers",
                "",
                R.drawable.demo
            )
        )
        mList.add(
            People(
                "Photographers",
                "",
                R.drawable.demo
            )
        )
    }

    override fun handleItemClick(_person: People, pos: Int) {
        if (pos == 0)
            navigate(
                EntertainmentFragmentDirections.actionEntertainmentFragmentToBlogersFragment()
            )
    }
}