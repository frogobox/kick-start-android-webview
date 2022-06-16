package com.frogobox.webview

import android.view.View
import android.webkit.*
import java.util.HashMap

// Created by KoinWorks (M. Faisal Amir) on 16/06/22.


fun WebView.loadUrlExt(url: String, auth: HashMap<String, String>) {
    apply {

        CookieManager.getInstance().setAcceptCookie(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(this, true)

        settings.javaScriptEnabled = true
        settings.setAppCacheEnabled(true)
        settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.NORMAL
        settings.loadWithOverviewMode = true
        settings.useWideViewPort = true
        settings.domStorageEnabled = true
        settings.mediaPlaybackRequiresUserGesture = false
        settings.loadsImagesAutomatically = true
        settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW

        settings.setSupportZoom(true)
        settings.builtInZoomControls = true
        settings.displayZoomControls = false

        scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY

        webChromeClient = WebChromeClient()
        webViewClient = WebViewClient()


    }.loadUrl(url, auth)

}

fun WebView.loadUrlExt(url: String) {
    apply {

        CookieManager.getInstance().setAcceptCookie(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(this, true)

        settings.javaScriptEnabled = true
        settings.setAppCacheEnabled(true)
        settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.NORMAL
        settings.loadWithOverviewMode = true
        settings.useWideViewPort = true
        settings.domStorageEnabled = true
        settings.mediaPlaybackRequiresUserGesture = false
        settings.loadsImagesAutomatically = true
        settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW

        settings.setSupportZoom(true)
        settings.builtInZoomControls = true
        settings.displayZoomControls = false

        scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY

        webChromeClient = WebChromeClient()
        webViewClient = WebViewClient()


    }.loadUrl(url)

}