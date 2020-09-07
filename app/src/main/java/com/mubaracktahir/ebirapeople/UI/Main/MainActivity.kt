package com.mubaracktahir.ebirapeople.UI.Main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.reward.RewardItem
import com.google.android.gms.ads.reward.RewardedVideoAd
import com.google.android.gms.ads.reward.RewardedVideoAdListener
import com.mubaracktahir.ebirapeople.R
import com.mubaracktahir.ebirapeople.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), RewardedVideoAdListener {
    lateinit var binding: ActivityMainBinding;
    lateinit var navController: NavController

    private lateinit var mRewardedVideoAd: RewardedVideoAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //D40 nikon
        MobileAds.initialize(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this)
        mRewardedVideoAd.rewardedVideoAdListener = this
        loadRewardedVideoAd()
        setUpNavController()
    }

    private fun loadRewardedVideoAd() {
        mRewardedVideoAd.loadAd("ca-app-pub-2619885239553733/6352789853",
            AdRequest.Builder().build())
    }

    private fun setUpNavController() {
        navController = findNavController(R.id.navHostFragment)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment -> {
                    if (mRewardedVideoAd.isLoaded)
                    mRewardedVideoAd.show()
                }
                R.id.historyFragment -> {
                    if (mRewardedVideoAd.isLoaded)
                        mRewardedVideoAd.show()
                }
                R.id.cultureFragment -> {
                    if (mRewardedVideoAd.isLoaded)
                        mRewardedVideoAd.show()
                }
                R.id.peopleFragment -> {
                    if (mRewardedVideoAd.isLoaded)
                        mRewardedVideoAd.show()
                }
                R.id.entertainmentFragment -> {
                    if (mRewardedVideoAd.isLoaded)
                        mRewardedVideoAd.show()
                }

            }
        }
    }

    override fun onRewarded(reward: RewardItem) {
    }

    override fun onRewardedVideoAdLeftApplication() {
    }

    override fun onRewardedVideoAdClosed() {
        loadRewardedVideoAd()
    }

    override fun onRewardedVideoAdFailedToLoad(errorCode: Int) {
    }

    override fun onRewardedVideoAdLoaded() {
    }

    override fun onRewardedVideoAdOpened() {
    }

    override fun onRewardedVideoStarted() {
    }

    override fun onRewardedVideoCompleted() {
    }
    override fun onPause() {
        super.onPause()
        mRewardedVideoAd.pause(this)
    }

    override fun onResume() {
        super.onResume()
        mRewardedVideoAd.resume(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        mRewardedVideoAd.destroy(this)
    }
}