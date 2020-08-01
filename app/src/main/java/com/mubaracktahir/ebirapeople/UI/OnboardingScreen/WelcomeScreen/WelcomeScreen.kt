package com.mubaracktahir.ebirapeople.UI.OnboardingScreen.WelcomeScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.mubaracktahir.ebirapeople.R
import kotlinx.android.synthetic.main.fragment_welcome_screen.view.*

class WelcomeScreen : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_welcome_screen, container, false)
        view.linearLayout.setOnClickListener {
            view?.let {
                _view ->
                Navigation.findNavController(_view).navigate(R.id.action_welcomeScreen_to_onBoarderParent)
            }
        }
        return view
    }


}