package com.frogobox.webview

import android.os.Bundle
import com.frogobox.webview.base.BaseActivity
import com.frogobox.webview.databinding.ActivityMainBinding


class MainActivity : BaseActivity<ActivityMainBinding>() {

    companion object {
        private const val URL_LINK_WEBSITE = "https://github.com/amirisback"
    }

    override fun setupViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        binding.mainWebview.loadUrlExt(URL_LINK_WEBSITE)
        showAdBanner(binding.adsView.adsPhoneTabSpecialSmartBanner)
        showAdInterstitial(getString(R.string.admob_interstitial))
    }

}