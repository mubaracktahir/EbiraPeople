package com.mubaracktahir.ebirapeople.UI.OnboardingScreen.screens

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mubaracktahir.ebirapeople.R


/**
 * A simple [Fragment] subclass.
 * Use the [ThirdScreen.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThirdScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        onBoardingFinished()
        return inflater.inflate(R.layout.fragment_thirfd_screen, container, false)
    }

    fun onBoardingFinished() {
        var sharedPref = requireActivity().getSharedPreferences(
            "onBoarding"
            , Context.MODE_PRIVATE
        )
        val editor = sharedPref.edit()
        editor.putBoolean("finished",true)
        editor.apply()
    }
}