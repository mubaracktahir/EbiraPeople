package com.mubaracktahir.ebirapeople.UI.BeautifulPlaces

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.viewpager.widget.PagerAdapter
import com.mubaracktahir.ebirapeople.R
import com.mubaracktahir.ebirapeople.models.Place
import kotlinx.android.synthetic.main.beautiful_places_item.view.*


/**
 * Created by Mubarak Tahir on 8/14/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */
class ViewPagerAdapter(
    val list: List<Place>,
    val context: Context
) : PagerAdapter() {


    override fun getCount() = list.size

    override fun isViewFromObject(view: View, obj: Any) = view == obj as RelativeLayout

    override fun instantiateItem(container: ViewGroup, position: Int): Any {


        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.beautiful_places_item, container, false)
        container.addView(view)
        view.place.setImageResource(list[position].images[0])
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)
    }

}