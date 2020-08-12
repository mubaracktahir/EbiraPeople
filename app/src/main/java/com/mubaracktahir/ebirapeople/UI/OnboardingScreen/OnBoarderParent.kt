package com.mubaracktahir.ebirapeople.UI.OnboardingScreen

import android.graphics.Color
import android.text.Html
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.mubaracktahir.ebirapeople.R
import com.mubaracktahir.ebirapeople.UI.OnboardingScreen.screens.*
import com.mubaracktahir.ebirapeople.core.BaseFragment
import com.mubaracktahir.ebirapeople.databinding.FragmentOnBoarderParentBinding
import kotlinx.android.synthetic.main.fragment_on_boarder_parent.view.*


class OnBoarderParent : BaseFragment<FragmentOnBoarderParentBinding>(R.layout.fragment_on_boarder_parent) {
    var firstTime = true
    override fun init() {
        //List of Fragments in the onBoarding Screen
        val fragments = arrayListOf(
            FirstScreen(), SecondScreen(), ThirdScreen()
        )

        val viewPagerAdapter = ViewPagerAdapter(
            fragments, requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.linearLayout.setOnClickListener {
            when(binding.viewPager2.currentItem){
                0 -> binding.viewPager2.setCurrentItem(1)
                1 -> binding.viewPager2.setCurrentItem(2)
                else -> {

                    navigate(OnBoarderParentDirections.actionOnBoarderParentToHomeFragment())
                }
            }
        }
        addFirstDot(binding)


        //Listening to page callbacks
        binding.viewPager2.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    if (firstTime)
                        firstTime = false
                    else
                        addDot(position)
                    binding.text.text = if (position == 2)
                        getString(R.string.learn_more)
                    else
                        getString(R.string.next)
                }
            }
        )

        binding.viewPager2.adapter = viewPagerAdapter

    }

    // creates dot indicator for the first enterance of the onBoardingScreen
    fun addFirstDot(view: FragmentOnBoarderParentBinding) {

        view.pos1.setText(Html.fromHtml("&#8226;"))
        view.pos2.setText(Html.fromHtml("&#8226;"))
        view.pos3.setText(Html.fromHtml("&#8226;"))

        view.pos1.textSize = 50f
        view.pos2.textSize = 50f
        view.pos3.textSize = 50f

        view.pos1.setTextColor(Color.parseColor("#F74E2E"))
        view.pos2.setTextColor(Color.parseColor("#F74E2E"))
        view.pos3.setTextColor(Color.parseColor("#F74E2E"))
        view.pos1.setTextColor(Color.parseColor("#FFBA38"))
    }

    //creates dot indicator
    private fun addDot(position: Int) {
        val textViews = arrayOfNulls<TextView>(3)
        view?.let { it.liner.removeAllViews() }
        var i = 0
        while (i < 3) {

            textViews[i] = TextView(this.context)
            textViews[i]?.setText(Html.fromHtml("&#8226;"))
            textViews[i]?.textSize = 50f
            textViews[i]?.setTextColor(Color.parseColor("#F74E2E"))

            view?.let { _view ->
                _view.liner.addView(textViews[i])
            }
            i++

        }
        if (textViews.size > 0)
            textViews[position]?.setTextColor(Color.parseColor("#FFBA38"))

    }
}