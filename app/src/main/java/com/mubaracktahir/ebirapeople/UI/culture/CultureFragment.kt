package com.mubaracktahir.ebirapeople.UI.culture

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.recyclerview.widget.LinearLayoutManager
import com.mubaracktahir.ebirapeople.R
import com.mubaracktahir.ebirapeople.UI.PeopleFragment.RecyclerAdapter2
import com.mubaracktahir.ebirapeople.core.BaseFragment
import com.mubaracktahir.ebirapeople.databinding.FragmentListBinding
import com.mubaracktahir.ebirapeople.models.Place
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_list.view.*
import kotlinx.android.synthetic.main.search_template.view.*


/**
 * Created by Mubarak Tahir on 8/13/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */
class CultureFragment : BaseFragment<FragmentListBinding>(R.layout.fragment_list) {


    val mPlacesList = ArrayList<Place>()

    val adapter2 by lazy {
        RecyclerAdapter2 { place, pos ->
            handleItemClick2(place, pos)
        }
    }


    val textWatcher = object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
            filter(p0.toString().trim());
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }
    }


    fun addList() {
        mPlacesList.add(
            Place(
                passString(R.string.c1),
                passString(R.string.c1_d),
                R.drawable.ane1,
                R.drawable.ane2,
                R.drawable.ane3,
                R.drawable.ane4,
                R.drawable.ane5,
                R.drawable.ane6,
                R.drawable.ane7,
                R.drawable.ane8,
                R.drawable.ane9
            )
        )
        mPlacesList.add(
            Place(
                passString(R.string.c2),
                passString(R.string.c2_d),
                R.drawable.ori2,
                R.drawable.ori1,
                R.drawable.ori3
            )
        )
        mPlacesList.add(Place(passString(R.string.c3), passString(R.string.c3_d)))
    }

    override fun init() {
        binding.root.searchView.addTextChangedListener(textWatcher)
        binding.root.recycler.let { _recyclerView ->
            _recyclerView.setHasFixedSize(true)
            _recyclerView.layoutManager = LinearLayoutManager(context)
            _recyclerView.adapter = adapter2

        }
        adapter2.places.clear()
        adapter2.places.addAll(mPlacesList)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addList()
    }

    fun filter(query: String) {
        val place = ArrayList<Place>()
        mPlacesList.forEach {
            it.name?.let { _it ->
                if (_it.toLowerCase().trim().contains(query.toLowerCase().trim())) {
                    place.add(it)
                }
            }

        }
        adapter2.places = place
    }

    fun handleItemClick2(_place: Place, pos: Int) {
        navigate(CultureFragmentDirections.actionCultureFragmentToPlacesDisplayerFragment(_place))
    }
}