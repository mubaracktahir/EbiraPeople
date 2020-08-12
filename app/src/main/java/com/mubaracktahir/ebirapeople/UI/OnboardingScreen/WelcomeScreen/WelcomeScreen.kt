package com.mubaracktahir.ebirapeople.UI.OnboardingScreen.WelcomeScreen

import androidx.navigation.fragment.findNavController
import com.mubaracktahir.ebirapeople.core.BaseFragment
import com.mubaracktahir.ebirapeople.R
import com.mubaracktahir.ebirapeople.databinding.FragmentWelcomeScreenBinding

import kotlinx.android.synthetic.main.fragment_welcome_screen.view.*

class WelcomeScreen : BaseFragment<FragmentWelcomeScreenBinding>(R.layout.fragment_welcome_screen){
    override fun init() {
        binding.linearLayout.setOnClickListener {
            navigate(WelcomeScreenDirections.actionWelcomeScreenToOnBoarderParent())
        }
    }

}