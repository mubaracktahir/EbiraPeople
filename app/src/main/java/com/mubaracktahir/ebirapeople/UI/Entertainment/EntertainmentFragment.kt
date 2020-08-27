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
        mPeopleList.add(
            People(
                passString(R.string.bloggers),
                "${passString(R.string.know_more)} ${passString(R.string.b1)}," +
                        "${passString(R.string.b2)},${passString(R.string.b3)} ",
                R.drawable.bloggers
            )
        )
        mPeopleList.add(
            People(
                passString(R.string.photographer),
                "${passString(R.string.know_more)} ${passString(R.string.ph1)}," +
                        "${passString(R.string.ph2)},${passString(R.string.ph3)} ",
                R.drawable.photograhy
            )
        )
    }

    override fun handleItemClick(_person: People, pos: Int) {
        if (pos == 0)
            navigate(
                EntertainmentFragmentDirections.actionEntertainmentFragmentToBlogersFragment()
            )
        if (pos == 1)
            navigate(
                EntertainmentFragmentDirections.actionEntertainmentFragmentToPhotographyFragment()
            )

    }
}