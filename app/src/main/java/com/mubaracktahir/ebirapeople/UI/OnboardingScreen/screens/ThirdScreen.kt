package com.mubaracktahir.ebirapeople.UI.OnboardingScreen.screens

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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

        return inflater.inflate(R.layout.fragment_third_screen, container, false)
    }
    private fun onBoardingFinished() {
        val sharedPref = requireActivity().getSharedPreferences("onBoardingScreen", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean(resources.getString(R.string.com_mubaracktahir_ebirapeople_onboarding_finished),true)
        editor.apply()
        editor.commit()
    }
}