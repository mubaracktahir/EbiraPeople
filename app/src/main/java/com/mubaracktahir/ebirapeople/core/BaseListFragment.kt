package com.mubaracktahir.ebirapeople.core

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.mubaracktahir.ebirapeople.R
import com.mubaracktahir.ebirapeople.UI.PeopleFragment.RecyclerAdapter
import com.mubaracktahir.ebirapeople.models.People
import kotlinx.android.synthetic.main.fragment_list.view.*
import kotlinx.android.synthetic.main.search_template.view.*


/**
 * Created by Mubarak Tahir on 8/8/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */
abstract class BaseListFragment<DB : ViewDataBinding>() : BaseFragment<DB>(R.layout.fragment_list) {

    val mPeopleList = ArrayList<People>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addList()
    }

    private val adapter by lazy {
        RecyclerAdapter { _person, pos ->
            handleItemClick(_person, pos)
        }
    }

    abstract fun handleItemClick(_person: People, pos: Int)
    abstract fun addList()
    override fun init() {
        binding.root.searchView.addTextChangedListener(textWatcher)
        binding.root.recycler.let {_recyclerView ->
            _recyclerView.setHasFixedSize(true)
            _recyclerView.layoutManager = LinearLayoutManager(context)
            _recyclerView.adapter = adapter
        }
        adapter.people.clear()
        adapter.people.addAll(mPeopleList)
    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
            filter(p0.toString().trim());
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }
    }


    private fun filter(query: String) {
        val people = ArrayList<People>()
        mPeopleList.forEach {
            it.name?.let { _it ->
                if (_it.toLowerCase().trim().contains(query.toLowerCase().trim())) {
                    people.add(it)
                }
            }

        }
        adapter.people = people
    }
}