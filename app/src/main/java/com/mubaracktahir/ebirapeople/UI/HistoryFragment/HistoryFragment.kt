package com.mubaracktahir.ebirapeople.UI.HistoryFragment

import android.view.View
import com.mubaracktahir.ebirapeople.core.BaseFragment
import com.mubaracktahir.ebirapeople.R
import com.mubaracktahir.ebirapeople.databinding.FragmentHistoryBinding


class HistoryFragment : BaseFragment<FragmentHistoryBinding>(R.layout.fragment_history) {
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