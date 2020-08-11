package com.mubaracktahir.ebirapeople.core

import android.view.View
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding


/**
 * Created by Mubarak Tahir on 8/11/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */
open class FullScreenFragment<DB: ViewDataBinding>(@LayoutRes layout:Int) : BaseFragment<DB>(layout) {

    override fun onResume() {
        super.onResume()
        activity?.window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LOW_PROFILE or
                View.SYSTEM_UI_FLAG_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
    }

    override fun onDestroy() {
        super.onDestroy()
        activity?.window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
    }
}