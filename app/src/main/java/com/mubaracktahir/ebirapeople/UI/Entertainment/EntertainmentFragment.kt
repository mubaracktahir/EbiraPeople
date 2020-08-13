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
                "Know more about the likes of: ${passString(R.string.b1)}," +
                        "${passString(R.string.b2)},${passString(R.string.b3)} ",
                R.drawable.demo
            )
        )
        mList.add(
            People(
                "Photographers",
                "Know more about the likes of: ${passString(R.string.ph1)}," +
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