package com.mubaracktahir.ebirapeople.UI.Home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.mubaracktahir.ebirapeople.R
import com.mubaracktahir.ebirapeople.UI.BeautifulPlaces.ViewPagerAdapter2
import com.mubaracktahir.ebirapeople.core.BaseFragment
import com.mubaracktahir.ebirapeople.databinding.FragmentHomeBinding
import com.mubaracktahir.ebirapeople.models.Place
import java.util.*
import kotlin.collections.ArrayList

/**
 * This is the Fragment that is Shown after the [SplashScreenFragment]
 *
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    override fun init() {
        setUpWidget()
    }

    /**
     * Setting up the UI component of [HomeFragment]
     * listening to clicks and scrolls from Views are in this Function
     *
     */
    fun setUpWidget() {
        binding.textView5.text = sayGreetings()
        binding.historyCard.setOnClickListener {
            navigate(HomeFragmentDirections.actionHomeFragmentToHistoryFragment())
        }
        binding.cultureCard.setOnClickListener {
            navigate(HomeFragmentDirections.actionHomeFragmentToCultureFragment())
        }
        binding.peopleCard.setOnClickListener {
            navigate(HomeFragmentDirections.actionHomeFragmentToPeopleFragment())
        }
        binding.entertainmentCard.setOnClickListener {
            navigate(HomeFragmentDirections.actionHomeFragmentToEntertainmentFragment())
        }


        // seting up the beautifulPlaces viewPager
        setUpBeautifulPlaces()
    }


    fun setUpBeautifulPlaces() {
        val mPlaces = ArrayList<Place>()
        mPlaces.add(
            Place(
                getString(R.string.be3),
                getString(R.string.be3_d),
                R.drawable.ohi1,
                R.drawable.ohi2,
                R.drawable.ohi3,
                R.drawable.ohi4
            )
        )
        mPlaces.add(
            Place(
                getString(R.string.be1),
                getString(R.string.be1_d),
                R.drawable.at1,
                R.drawable.at2,
                R.drawable.at3
            )
        )
        mPlaces.add(
            Place(
                getString(R.string.be4),
                getString(R.string.be4_d),
                R.drawable.ak1,
                R.drawable.ak2,
                R.drawable.ak3,
                R.drawable.ak4
            )
        )
        mPlaces.add(
            Place(
                getString(R.string.be2),
                getString(R.string.be2_d),
                R.drawable.up1,
                R.drawable.up3,
                R.drawable.up5
            )
        )


        val adapter = ViewPagerAdapter2(binding.recycler) { place, position ->
            navigate(HomeFragmentDirections.actionHomeFragmentToPlacesDisplayerFragment(place))
        }
        adapter.places = mPlaces
        binding.recycler.adapter = adapter
        binding.recycler.clipToPadding = false
        binding.recycler.clipChildren = false
        binding.recycler.offscreenPageLimit = 3
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(SelectedPageZoomer())
        binding.recycler.setPageTransformer(compositePageTransformer)
        android.os.Handler().postDelayed(
            {
               binding.recycler.adapter = adapter
                binding.recycler.setCurrentItem(2)
            }, 500
        )
    }

    class SelectedPageZoomer : ViewPager2.PageTransformer {
        override fun transformPage(page: View, position: Float) {
            val scaleFactor = 1 - Math.abs(position)
            page.scaleY = 0.85f + scaleFactor * 0.15f
        }
    }

    private fun sayGreetings(): String {
        val cal = Calendar.getInstance();
        val currentTimeOfTheDay = cal.get(Calendar.HOUR_OF_DAY)
        return when (currentTimeOfTheDay) {
            in 0..11 -> passString(R.string.good_mornig)
            in 12..15 -> passString(R.string.good_afternoon)
            in 16..20 -> passString(R.string.good_evening)
            else -> passString(R.string.good_night)
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpBeautifulPlaces()
    }
}
