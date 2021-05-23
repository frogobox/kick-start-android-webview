package com.frogobox.basewebview

import android.os.Bundle
import android.view.View.SCROLLBARS_INSIDE_OVERLAY
import android.webkit.WebViewClient
import com.frogobox.basewebview.base.BaseActivity


class MainActivity : BaseActivity() {

    companion object {
        private const val URL_LINK_WEBSITE = "https://github.com/amirisback"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)
        setupWebView(URL_LINK_WEBSITE)
        setupShowAdsBanner(mainBinding.adsView.adsPhoneTabSpecialSmartBanner)
        setupShowAdsInterstitial()
    }

    private fun setupWebView(url: String){
        mainBinding.mainWebview.apply {
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
