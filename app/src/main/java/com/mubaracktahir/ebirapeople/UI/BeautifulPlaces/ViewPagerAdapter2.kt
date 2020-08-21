package com.mubaracktahir.ebirapeople.UI.BeautifulPlaces

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.mubaracktahir.ebirapeople.R
import com.mubaracktahir.ebirapeople.models.Place
import kotlinx.android.synthetic.main.beautiful_places_item.view.*


/**
 * Created by Mubarak Tahir on 8/14/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */
class ViewPagerAdapter2(
    val viewPager2: ViewPager2?,
    val clickCallBack: (place: Place, position : Int) -> Unit
) : RecyclerView.Adapter<ViewPagerAdapter2.MyViewHolder>() {
    var places = ArrayList<Place>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {


        fun bind(place: Place, position: Int, clickCallBack: (place: Place, position : Int) -> Unit) {
            view.place.setImageResource(place.images[0])
            view.destination.setOnClickListener {
                Toast.makeText(view.context,"Coming Soon", Toast.LENGTH_LONG).show()
            }
            view.setOnClickListener {
                clickCallBack(place,position)
            }
        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.beautiful_places_item, parent, false)
                return MyViewHolder(view);
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun getItemCount() = places.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val place = places[position]
        holder.bind(place, position , clickCallBack)
    }

}