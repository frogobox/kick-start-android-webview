package com.frogobox.basewebview

import android.os.Bundle
import android.view.View.SCROLLBARS_INSIDE_OVERLAY
import android.webkit.WebViewClient
import com.frogobox.basewebview.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.ads_phone_tab_special_smart_banner.*


class MainActivity : BaseActivity() {

    companion object {
        private const val URL_LINK_WEBSITE = "https://disporaparbud.probolinggokab.go.id/"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupWebView(URL_LINK_WEBSITE)
        setupShowAdsBanner(ads_phone_tab_special_smart_banner)
        setupShowAdsInterstitial()
    }

    private fun setupWebView(url: String){
        main_webview.settings.loadsImagesAutomatically = true
        main_webview.settings.javaScriptEnabled = true
        main_webview.settings.domStorageEnabled = true

        main_webview.settings.setSupportZoom(true)
        main_webview.settings.builtInZoomControls = true
        main_webview.settings.displayZoomControls = false

        main_webview.scrollBarStyle = SCROLLBARS_INSIDE_OVERLAY
        main_webview.webViewClient = WebViewClient()
        main_webview.loadUrl(url)
    }



}
