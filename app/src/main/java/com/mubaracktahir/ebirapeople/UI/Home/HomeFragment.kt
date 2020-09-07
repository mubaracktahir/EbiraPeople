package com.mubaracktahir.ebirapeople.UI.Home

import android.os.Handler
import android.view.View
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.mubaracktahir.ebirapeople.R
import com.mubaracktahir.ebirapeople.UI.BeautifulPlaces.ViewPagerAdapter2
import com.mubaracktahir.ebirapeople.core.BaseFragment
import com.mubaracktahir.ebirapeople.databinding.FragmentHomeBinding
import com.mubaracktahir.ebirapeople.models.Place
import com.mubaracktahir.ebirapeople.utils.Constants
import java.util.*
import kotlin.collections.ArrayList

/**
 * This is the Fragment that is Shown after the [SplashScreenFragment]
 *
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private fun getEmoji(uniCode: Int) = String(Character.toChars(uniCode))
    override fun init() {
        setUpWidget()
    }

    /**
     * Setting up the UI component of [HomeFragment]
     * listening to clicks and scrolls from Views are in this Function
     *
     */
    private fun setUpWidget() {
        binding.textHi.append("${passString(R.string.hi)} ${getEmoji(0x1F44B)},")
        binding.greetingText.text = sayGreetings()
        val adView = AdView(context)
        adView.adSize = AdSize.SMART_BANNER
        adView.adUnitId = getString(R.string.unit_id)

        binding.ads.loadAd(AdRequest.Builder().build())

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

    private val mPlaces by lazy {
        ArrayList<Place>()
    }

    private val adapter by lazy {
        ViewPagerAdapter2(binding.recycler) { place, position ->
            navigate(HomeFragmentDirections.actionHomeFragmentToPlacesDisplayerFragment(place))
        }
    }

    private fun setUpBeautifulPlaces() {
        mPlaces.clear()
        mPlaces.apply {
            add(
                Place(
                    getString(R.string.be3),
                    getString(R.string.be3_d),
                    R.drawable.ohi1,
                    R.drawable.ohi2,
                    R.drawable.ohi3,
                    R.drawable.ohi4
                )
            )
            add(
                Place(
                    getString(R.string.be1),
                    getString(R.string.be1_d),
                    R.drawable.at1,
                    R.drawable.at2,
                    R.drawable.at3
                )
            )
            add(
                Place(
                    getString(R.string.be4),
                    getString(R.string.be4_d),
                    R.drawable.ak1,
                    R.drawable.ak2,
                    R.drawable.ak3,
                    R.drawable.ak4
                )
            )
            add(
                Place(
                    getString(R.string.be2),
                    getString(R.string.be2_d),
                    R.drawable.up1,
                    R.drawable.up3,
                    R.drawable.up5
                )
            )

        }
        //passing all the beautiful places to the ViewPager
        adapter.places = mPlaces
        binding.recycler.adapter = adapter
        binding.recycler.clipToPadding = false
        binding.recycler.clipChildren = false
        binding.recycler.offscreenPageLimit = 3
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(SelectedPageZoomer())
        binding.recycler.setPageTransformer(compositePageTransformer)
        binding.recycler.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == mPlaces.lastIndex) {
                    handler.postDelayed(Runnable {
                        binding.recycler.setCurrentItem(position * 0)
                    },1000)
                } else {
                    handler.removeCallbacks(runnable)
                    handler.postDelayed(runnable, 1000)
                }
            }
        })
    }

    class SelectedPageZoomer : ViewPager2.PageTransformer {
        override fun transformPage(page: View, position: Float) {


            val scaleFactor = 1 - Math.abs(position)

            // increase the scaleY of the focused or current view
            page.scaleY = 0.85f + scaleFactor * 0.15f
        }
    }

    /*
    *
    * displaces greeting depending on the time of the day
    *
    * */
    private fun sayGreetings(): String {

        //get an instance of the android calendar class
        val cal = Calendar.getInstance();

        // gets the current hour of the day
        val currentTimeOfTheDay = cal.get(Calendar.HOUR_OF_DAY)
        return when (currentTimeOfTheDay) {
            in 6..11 -> "${passString(R.string.good_mornig)} ${getEmoji(0x26C8)}"
            in 12..15 -> "${passString(R.string.good_afternoon)} ${getEmoji(0x1F31E)}"
            in 16..20 -> "${passString(R.string.good_evening)} ${getEmoji(0x1F31B)}"
            else -> "${passString(R.string.good_night)} ${getEmoji(0x1F644)}"
        }
    }

    private val runnable = Runnable {
        binding.recycler.let {
            it.setCurrentItem(it.currentItem + 1)
        }
    }
    private val handler = Handler()
    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable, Constants.ONE_SECOND)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }
}
