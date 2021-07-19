package com.frogobox.webview

import android.os.Bundle
import android.view.View.SCROLLBARS_INSIDE_OVERLAY
import android.webkit.WebViewClient
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
        setupWebView(URL_LINK_WEBSITE)
        setupShowAdsBanner(binding.adsView.adsPhoneTabSpecialSmartBanner)
        setupShowAdsInterstitial()
    }

    private fun setupWebView(url: String){
        binding.mainWebview.apply {
            settings.loadsImagesAutomatically = true
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true

            settings.setSupportZoom(true)
            settings.builtInZoomControls = true
            settings.displayZoomControls = false

            scrollBarStyle = SCROLLBARS_INSIDE_OVERLAY
            webViewClient = WebViewClient()
            loadUrl(url)
        }
    }

}