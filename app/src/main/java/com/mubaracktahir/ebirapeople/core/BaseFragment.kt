package com.mubaracktahir.ebirapeople.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment


/**
 * Created by Mubarak Tahir on 8/9/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */
abstract class BaseFragment(@LayoutRes open val layoutRes: Int) : Fragment() {
    open lateinit var views: View
    private fun init(inflater: LayoutInflater, container: ViewGroup) {
        views = inflater.inflate(layoutRes, container, false)
    }
    open fun init(){}
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        init(inflater, container!!)
        init()
        super.onCreateView(inflater, container, savedInstanceState)
        return views
    }
}