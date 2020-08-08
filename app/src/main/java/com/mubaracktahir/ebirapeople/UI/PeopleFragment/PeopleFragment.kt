package com.mubaracktahir.ebirapeople.UI.PeopleFragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mubaracktahir.ebirapeople.R
import kotlinx.android.synthetic.main.search_template.view.*


/**
 * A simple [Fragment] subclass.
 *
 */
class PeopleFragment : Fragment() {
    val adapter by lazy {
        RecyclerAdapter()
    }


    val textWatcher = object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
            filter(p0.toString());
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            Log.v("", "")
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            Log.v("", "")

        }
    })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.fragment_list, container, false)
        v.searchView.addTextChangedListener(textWatcher)

        addPeple()
        var recyclerView = v.findViewById<RecyclerView>(R.id.recycler)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter.people.addAll(mList)
        adapter.notifyDataSetChanged()
        recyclerView.adapter = adapter

        // Inflate the layout for this fragment
        return v
    }

    fun addPeple() {
        mList.add(People(resources.getString(R.string.p3), resources.getString(R.string.p3_d), 0))
        mList.add(People(resources.getString(R.string.p4), resources.getString(R.string.p4_d), 0))
        mList.add(People(resources.getString(R.string.p5), resources.getString(R.string.p5_d), 0))
        mList.add(People(resources.getString(R.string.p6), resources.getString(R.string.p6_d), 0))
        mList.add(People(resources.getString(R.string.p7), resources.getString(R.string.p7_d), 0))
        mList.add(People(resources.getString(R.string.p8), resources.getString(R.string.p8_d), 0))
        mList.add(People(resources.getString(R.string.p9), resources.getString(R.string.p9_d), 0))
        mList.add(People(resources.getString(R.string.p10), resources.getString(R.string.p10_d), 0))
        mList.add(People(resources.getString(R.string.p11), resources.getString(R.string.p11_d), 0))
        mList.add(People(resources.getString(R.string.p12), resources.getString(R.string.p12_d), 0))
        mList.add(People(resources.getString(R.string.p13), resources.getString(R.string.p13_d), 0))
        mList.add(People(resources.getString(R.string.p14), resources.getString(R.string.p14_d), 0))
        mList.add(People(resources.getString(R.string.p15), resources.getString(R.string.p15_d), 0))
    }

    val mList = ArrayList<People>()

    fun filter(query: String) {

        val people = ArrayList<People>()
        mList.forEach {
            if (it.name.toLowerCase().contains(query.toLowerCase())) {
                people.add(it)
            }
        }
        adapter.people = people
    }

}