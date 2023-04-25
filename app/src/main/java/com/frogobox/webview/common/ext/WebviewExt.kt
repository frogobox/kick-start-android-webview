package com.frogobox.webview.common.ext

import android.annotation.SuppressLint
import android.os.Build
import android.view.View
import android.webkit.*
import com.frogobox.webview.common.callback.WebViewCallback

/**
 * Created by Faisal Amir on 24/10/22
 * -----------------------------------------
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) Frogobox ID / amirisback
 * All rights reserved
 */

@SuppressLint("SetJavaScriptEnabled")
fun WebView.loadUrlExt(url: String, auth: HashMap<String, String>, callback: WebViewCallback) {
    callback.onShowProgress()

    if (!url.contains("http") || !url.contains("https")) {
        callback.onHideProgress()
        callback.onFailed()
    } else {

        CookieManager.getInstance().setAcceptCookie(true)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
        }

        apply {

            settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.NORMAL
            settings.mediaPlaybackRequiresUserGesture = false
            settings.loadsImagesAutomatically = true
            settings.loadWithOverviewMode = true
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            settings.useWideViewPort = true

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
            }

            settings.setSupportZoom(true)
            settings.builtInZoomControls = true
            settings.displayZoomControls = false

            scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY

            webChromeClient = WebChromeClient()

            webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    callback.onHideProgress()
                    callback.onFinish()
                }

                override fun onReceivedError(
                    view: WebView?,
                    request: WebResourceRequest?,
                    error: WebResourceError?,
                ) {
                    super.onReceivedError(view, request, error)
                    callback.onHideProgress()
                    callback.onFailed()
                }
            }

        }.loadUrl(url, auth)

    }

}

@SuppressLint("SetJavaScriptEnabled")
fun WebView.loadUrlExt(url: String, callback: WebViewCallback) {
    callback.onShowProgress()

    if (!url.contains("http") || !url.contains("https")) {
        callback.onHideProgress()
        callback.onFailed()
    } else {

        CookieManager.getInstance().setAcceptCookie(true)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this, true)
        }

        apply {

            settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.NORMAL
            settings.mediaPlaybackRequiresUserGesture = false
            settings.loadsImagesAutomatically = true
            settings.loadWithOverviewMode = true
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            settings.useWideViewPort = true

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
            }

            settings.setSupportZoom(true)
            settings.builtInZoomControls = true
            settings.displayZoomControls = false

            scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY

            webChromeClient = WebChromeClient()

            webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    callback.onHideProgress()
                    callback.onFinish()
                }

                override fun onReceivedError(
                    view: WebView?,
                    request: WebResourceRequest?,
                    error: WebResourceError?,
                ) {
                    super.onReceivedError(view, request, error)
                    callback.onHideProgress()
                    callback.onFailed()
                }
            }

        }.loadUrl(url)

    }

}

@SuppressLint("SetJavaScriptEnabled")
fun WebView.loadUrlExt(url: String, auth: HashMap<String, String>) {

    loadUrlExt(url, auth, object : WebViewCallback {
        override fun onShowProgress() {}
        override fun onHideProgress() {}
        override fun onFinish() {}
        override fun onFailed() {}
    })

}

@SuppressLint("SetJavaScriptEnabled")
fun WebView.loadUrlExt(url: String) {

    loadUrlExt(url, object : WebViewCallback {
        override fun onShowProgress() {}
        override fun onHideProgress() {}
        override fun onFinish() {}
        override fun onFailed() {}
    })

}