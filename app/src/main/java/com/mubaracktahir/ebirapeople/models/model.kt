package com.mubaracktahir.ebirapeople.models

import android.os.Parcel
import android.os.Parcelable
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
data class People(val name: String, val desc: String, val image: Int = 0) : Parcelable