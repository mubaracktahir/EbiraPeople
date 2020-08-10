package com.mubaracktahir.ebirapeople.UI.OnboardingScreen.WelcomeScreen

import androidx.navigation.fragment.findNavController
import com.mubaracktahir.ebirapeople.core.BaseFragment
import com.mubaracktahir.ebirapeople.R
import kotlinx.android.synthetic.main.fragment_welcome_screen.view.*

class WelcomeScreen : BaseFragment(R.layout.fragment_welcome_screen){
    override fun init() {
        views.linearLayout.setOnClickListener {
            findNavController().navigate(WelcomeScreenDirections.actionWelcomeScreenToOnBoarderParent())
        }
    }

}