package com.mubaracktahir.ebirapeople.UI.SplashScreen

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.mubaracktahir.ebirapeople.R

class SplashScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_splash_screen,container,false)
    }

    override fun onResume() {
        super.onResume()
        Handler().postDelayed(
            {

                view?.let {_view ->
                    Navigation.findNavController(_view).navigate(R.id.action_splashScreenFragment_to_welcomeScreen)
                }
            }, 1000
        )
    }
}