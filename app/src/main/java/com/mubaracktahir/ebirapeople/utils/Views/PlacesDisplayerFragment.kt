package com.mubaracktahir.ebirapeople.utils.Views

import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mubaracktahir.ebirapeople.R
import com.mubaracktahir.ebirapeople.UI.BeautifulPlaces.MoreImagesAdapter
import com.mubaracktahir.ebirapeople.core.FullScreenFragment
import com.mubaracktahir.ebirapeople.databinding.FragmentPlacesDisplayerBinding
import kotlinx.android.synthetic.main.fragment_list.view.*


/**
 * A simple [Fragment] subclass.
 *
 */
class PlacesDisplayerFragment :
    FullScreenFragment<FragmentPlacesDisplayerBinding>(R.layout.fragment_places_displayer) {

    val adapter by lazy {
        MoreImagesAdapter { _places, pos ->
            binding.imageView2.setImageResource(_places)
            binding.appbar.setExpanded(true)
        }
    }
    override fun init() {
        val args =
            PlacesDisplayerFragmentArgs.fromBundle(
                requireArguments()
            )
        val place = args.place
        binding.place = place

        binding.fabs.setOnClickListener {
            //activity?.supportFragmentManager?.popBackStack()
            view?.findNavController()?.popBackStack()
        }

        binding.root.recycler.let { _recyclerView ->
            _recyclerView.setHasFixedSize(true)
            _recyclerView.layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
            _recyclerView.adapter = adapter
        }
        adapter.places.clear()
        place.images.forEach {
            adapter.places.add(it)
        }
        binding.recycler.adapter = adapter
        binding.executePendingBindings()

    }

}