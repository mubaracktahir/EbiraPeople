package com.mubaracktahir.ebirapeople.core

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.mubaracktahir.ebirapeople.R
import com.mubaracktahir.ebirapeople.models.People
import com.mubaracktahir.ebirapeople.models.Place


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


//Todo: got to refactor this later, bad idea (>_<)

@BindingAdapter("name")
fun TextView.setName(item: Place) {

    item?.let {
        text = item.name
    }
}

@BindingAdapter("description")
fun TextView.setDescription(item: Place) {

    item?.let {
        text = item.desc
    }
}
var i = 0
@BindingAdapter("image")
fun ImageView.setImage(item: Place) {

    item?.let {

        if (it.images.isEmpty())
            setImageResource(R.drawable.placeholder)
        else
            setImageResource(it.images[0])

    }
}

@BindingAdapter("horizontalImage")
fun ImageView.setImage2(item: Place) {

    item?.images.let {

        if (it.isEmpty())
            setImageResource(R.drawable.placeholder)
        else
            setImageResource(R.drawable.photograhy)

    }
}

