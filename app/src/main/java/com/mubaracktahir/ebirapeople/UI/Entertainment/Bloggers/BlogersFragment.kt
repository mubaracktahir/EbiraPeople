package com.mubaracktahir.ebirapeople.UI.Entertainment.Bloggers

import com.mubaracktahir.ebirapeople.R
import com.mubaracktahir.ebirapeople.core.BaseListFragment
import com.mubaracktahir.ebirapeople.databinding.FragmentListBinding
import com.mubaracktahir.ebirapeople.models.People


/**
 * Created by Mubarak Tahir on 8/12/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */
class BlogersFragment : BaseListFragment<FragmentListBinding>() {
    override fun handleItemClick(_person: People, pos: Int) {
        navigate(BlogersFragmentDirections.actionBlogersFragmentToPersonFragment(_person))
    }

    override fun addList() {
        mList.add(People(passString(R.string.b1),passString(R.string.b1_d)))
        mList.add(People(passString(R.string.b2),passString(R.string.b2_d)))
        mList.add(People(passString(R.string.b3),passString(R.string.b3_d)))
        mList.add(People(passString(R.string.b4),passString(R.string.b4_d)))
        mList.add(People(passString(R.string.b5),passString(R.string.b5_d)))
        mList.add(People(passString(R.string.b6),passString(R.string.b6_d)))

    }
}