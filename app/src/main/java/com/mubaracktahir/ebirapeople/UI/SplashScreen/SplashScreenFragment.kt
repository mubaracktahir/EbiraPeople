package com.mubaracktahir.ebirapeople.UI.SplashScreen

import android.content.Context
import android.os.Handler
import androidx.navigation.Navigation
import com.mubaracktahir.ebirapeople.core.BaseFragment
import com.mubaracktahir.ebirapeople.R
import com.mubaracktahir.ebirapeople.databinding.FragmentSplashScreenBinding

class SplashScreenFragment : BaseFragment<FragmentSplashScreenBinding>(R.layout.fragment_splash_screen) {

    override fun onResume() {
        super.onResume()
        Handler().postDelayed(
            {
                if (onBoardingFinish()) {
                    view?.let { _view ->
                        Navigation.findNavController(_view)
                            .navigate(R.id.action_splashScreenFragment_to_homeFragment)
                    }
                } else {
                    view?.let { _view ->
                        Navigation.findNavController(_view)
                            .navigate(R.id.action_splashScreenFragment_to_welcomeScreen)
                    }
                }

            }, 1000
        )
    }

    fun onBoardingFinish(): Boolean {
        var sharedPref = requireActivity().getSharedPreferences(
            "onBoarding"
            , Context.MODE_PRIVATE
        )
        val editor = sharedPref.edit()
        return sharedPref.getBoolean("finished", false)

    }
}