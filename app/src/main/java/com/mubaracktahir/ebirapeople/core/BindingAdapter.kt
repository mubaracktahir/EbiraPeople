package com.mubaracktahir.ebirapeople.core

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.mubaracktahir.ebirapeople.models.People


/**
 * Created by Mubarak Tahir on 8/9/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */
@BindingAdapter("name")
fun TextView.setName(item: People) {

    item?.let {
        text = item.name
    }
}

@BindingAdapter("description")
fun TextView.setDescription(item: People) {

    item?.let {
        text = item.desc
    }
}

@BindingAdapter("image")
fun ImageView.setImage(item: People) {

    item?.let {
        setImageResource(item.image)
    }
}


