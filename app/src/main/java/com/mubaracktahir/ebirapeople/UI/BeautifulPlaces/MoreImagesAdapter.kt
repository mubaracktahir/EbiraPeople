package com.mubaracktahir.ebirapeople.UI.BeautifulPlaces

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mubaracktahir.ebirapeople.databinding.MorePicturesItemBinding
/**
 * Created by Mubarak Tahir on 8/14/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */
class MoreImagesAdapter(val clickListener: (person: Int, position: Int) -> Unit) :
    RecyclerView.Adapter<MoreImagesAdapter.MyViewHolder>() {
    /**
     * the list of items that this adapter uses to display item on the [RecyclerView]
     */
    var places = ArrayList<Int>()
        set(value) {
            field = value

            /**
             *
             * this tells the the [RecyclerView] that the list has been updated
             * this will make every item on the list to be redrawn.
             *
             */
            notifyDataSetChanged()
        }

    /**
     * part of the recycler Adapter called when [RecyclerView] needs a new [ViewHolder]
     *
     * the [ViewHolder] holds a view for the [RecyclerView]
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    /**
     * This tells the [RecyclerView] the size of the [places]
     */
    override fun getItemCount() = places.size

    /**
     * this is called when [RecyclerView] needs to display item on the screen
     *
     * the [ViewHolder] passed are recycled i.e replaced, so we ensure that we resset any property that
     * may have been previously set
     *
     */
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val place = places[position]
        holder.bind(place,position , clickListener)
    }

    /**
     *
     */
    class MyViewHolder(val binding: MorePicturesItemBinding) : RecyclerView.ViewHolder(binding.root) {


        /**
         *
         */
        fun bind(
            place: Int,
            position: Int,
            clickListener: (place: Int, position: Int) -> Unit
        ) {
            binding.place.setImageResource(place)
            binding.root.setOnClickListener {
                clickListener(place, position)
            }
        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MorePicturesItemBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding);
            }
        }
    }


}
