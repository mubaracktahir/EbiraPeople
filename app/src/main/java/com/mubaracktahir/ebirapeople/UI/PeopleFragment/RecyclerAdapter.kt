package com.mubaracktahir.ebirapeople.UI.PeopleFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mubaracktahir.ebirapeople.R


/**
 * Created by Mubarak Tahir on 8/8/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */
data class People(val name: String, val desc: String, val image: Int)
class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    var people = ArrayList<People>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_model, parent, false)

        return MyViewHolder(view);
    }

    override fun getItemCount() = people.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val person = people[position]
        holder.setUpView(person)
    }

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun setUpView(person:People){
            var imageView = view.findViewById<ImageView>(R.id.image)
            var name = view.findViewById<TextView>(R.id.name)
            var description = view.findViewById<TextView>(R.id.description)

            imageView.setImageResource(R.drawable.king)
            name.text = person.name
            description.text = person.desc

        }
    }
}