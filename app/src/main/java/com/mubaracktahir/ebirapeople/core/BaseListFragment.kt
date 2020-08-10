package com.mubaracktahir.ebirapeople.core

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.mubaracktahir.ebirapeople.UI.PeopleFragment.RecyclerAdapter
import com.mubaracktahir.ebirapeople.models.People
import kotlinx.android.synthetic.main.fragment_list.view.*
import kotlinx.android.synthetic.main.search_template.view.*


/**
 * Created by Mubarak Tahir on 8/8/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */
abstract class BaseListFragment<DB:ViewDataBinding>(@LayoutRes override val layoutRes: Int) : BaseFragment<DB>(layoutRes) {

    val mList = ArrayList<People>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addList()
    }

    private val adapter by lazy {
        RecyclerAdapter { _person ->
            handleItemClick(_person)
        }
    }

    abstract fun handleItemClick(_person: People)
    abstract fun addList()
    override fun init() {

        binding.root.searchView.addTextChangedListener(textWatcher)
        binding.root.recycler.let {
            it.setHasFixedSize(true)
            it.layoutManager = LinearLayoutManager(context)
            it.adapter = adapter

        }
        adapter.people.clear()
        adapter.people.addAll(mList)
    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
            filter(p0.toString().trim());
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            Log.v("", "")
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            Log.v("", "")
        }
    }


    private fun filter(query: String) {
        val people = ArrayList<People>()
        mList.forEach {
            it.name?.let { _it ->
                if (_it.toLowerCase().trim().contains(query.toLowerCase().trim())) {
                    people.add(it)
                }
            }

        }
        adapter.people = people
    }
}