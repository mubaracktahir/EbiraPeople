package com.mubaracktahir.ebirapeople.UI.PeopleFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mubaracktahir.ebirapeople.UI.PeopleFragment.RecyclerAdapter.MyViewHolder.Companion.from
import com.mubaracktahir.ebirapeople.databinding.ItemModelBinding
import com.mubaracktahir.ebirapeople.models.People


/**
 * Created by Mubarak Tahir on 8/8/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */
class RecyclerAdapter(val clickListener: (person:People) -> Unit) :
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {
    /**
     * the list of items that this adapter uses to display item on the [RecyclerView]
     */
    var people = ArrayList<People>()
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
        return from(parent)
    }

    /**
     * This tells the [RecyclerView] the size of the [people]
     */
    override fun getItemCount() = people.size

    /**
     * this is called when [RecyclerView] needs to display item on the screen
     *
     * the [ViewHolder] passed are recycled i.e replaced, so we ensure that we resset any property that
     * may have been previously set
     *
     */
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val person = people[position]
        holder.bind(person,clickListener)
    }

    /**
     *
     */
    class MyViewHolder(val binding: ItemModelBinding) : RecyclerView.ViewHolder(binding.root) {


        /**
         *
         */
        fun bind(person: People, clickListener:(person:People)->Unit) {
            binding.item = person
            binding.executePendingBindings()
            binding.root.setOnClickListener {
                clickListener(person)
            }
        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemModelBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding);
            }
        }
    }


}
