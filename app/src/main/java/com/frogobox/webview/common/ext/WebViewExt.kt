package com.frogobox.webview.common.ext

import android.annotation.SuppressLint
import android.view.View
import android.webkit.CookieManager
import android.webkit.WebChromeClient
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
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
fun WebView.loadUrlExt(
    url: String,
    auth: HashMap<String, String>? = null,
    callback: WebViewCallback? = null,
) {
    callback?.onShowProgress()

    if (url == "") {
        callback?.onHideProgress()
        callback?.onFailed()
    } else {

        CookieManager.getInstance().setAcceptCookie(true)
        CookieManager.getInstance().setAcceptThirdPartyCookies(this, true)

        apply {

            settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.NORMAL
            settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW

            settings.mediaPlaybackRequiresUserGesture = false
            settings.loadsImagesAutomatically = true
            settings.loadWithOverviewMode = true

            settings.useWideViewPort = true
            settings.allowFileAccess = true
            settings.allowContentAccess = true

            settings.javaScriptEnabled = true
            settings.javaScriptCanOpenWindowsAutomatically = true
            settings.domStorageEnabled = true

            settings.setSupportZoom(true)
            settings.builtInZoomControls = true
            settings.displayZoomControls = false

            scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY

            webChromeClient = WebChromeClient()

            webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    callback?.onHideProgress()
                    callback?.onFinish()
                }

                override fun onReceivedError(
                    view: WebView?,
                    request: WebResourceRequest?,
                    error: WebResourceError?,
                ) {
                    super.onReceivedError(view, request, error)
                    callback?.onHideProgress()
                    callback?.onFailed()
                }
            }

        }

        if (url.contains("</html>") || url.contains("</div>") || url.contains("</body>")) {
            loadDataWithBaseURL(null, url, "text/html", "utf-8", null)
        } else {
            val validUrl = url.validateUrl()

            if (!validUrl.isValidUrl()) {
                callback?.onHideProgress()
                callback?.onFailed()
            } else {
                auth?.let {
                    loadUrl(validUrl, it)
                } ?: run {
                    loadUrl(validUrl)
                }
            }
        }

    }

}