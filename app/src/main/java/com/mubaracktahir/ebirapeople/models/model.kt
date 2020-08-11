package com.mubaracktahir.ebirapeople.models

import android.os.Parcelable
import com.mubaracktahir.ebirapeople.R
import kotlinx.android.parcel.Parcelize


/**
 * Created by Mubarak Tahir on 8/9/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */
/**
 * the model for the item to be displayed
 */
@Parcelize
data class People(val name: String, val desc: String, val image: Int = R.drawable.placeholder) :
    Parcelable

@Parcelize
data class Place(val name: String, val desc: String, val images: List<Int>) : Parcelable
