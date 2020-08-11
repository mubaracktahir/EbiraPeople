package com.mubaracktahir.ebirapeople.UI.BeautifulPlaces

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mubaracktahir.ebirapeople.R


/**
 * A simple [Fragment] subclass.
 *
 */
class PlacesDisplayerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_places_displayer, container, false)
    }

}