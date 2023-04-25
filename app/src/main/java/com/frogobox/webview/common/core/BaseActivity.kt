package com.frogobox.webview.common.core

import androidx.viewbinding.ViewBinding
import com.frogobox.admob.callback.FrogoAdmobInterstitialCallback
import com.frogobox.admob.ui.FrogoAdmobBindActivity
import com.frogobox.webview.R
import com.frogobox.webview.common.callback.AdCallback

/**
 * Created by Faisal Amir on 24/10/22
 * -----------------------------------------
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) Frogobox ID / amirisback
 * All rights reserved
 */


abstract class BaseActivity<VB : ViewBinding> : FrogoAdmobBindActivity<VB>() {

    protected fun showInterstitial(callback: AdCallback) {
        showAdInterstitial(getString(R.string.admob_interstitial),
            object : FrogoAdmobInterstitialCallback {

                override fun onAdLoaded(tag: String, message: String) {}

                override fun onAdShowed(tag: String, message: String) {}

                override fun onHideAdRequestProgress(tag: String, message: String) {
                    callback.onHideProgress()
                }

                override fun onShowAdRequestProgress(tag: String, message: String) {
                    callback.onShowProgress()
                }

                override fun onAdDismissed(tag: String, message: String) {
                    callback.onFinish()
                }

                override fun onAdFailed(tag: String, errorMessage: String) {
                    callback.onFailed()
                }
            })
    }

}