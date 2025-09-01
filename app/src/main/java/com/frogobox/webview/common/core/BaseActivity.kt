package com.frogobox.webview.common.core

import android.app.Activity
import androidx.viewbinding.ViewBinding
import com.frogobox.ads.callback.FrogoAdmobInterstitialCallback
import com.frogobox.ads.core.IFrogoAdConsent
import com.frogobox.ads.ui.FrogoAdmobBindActivity
import com.frogobox.coresdk.util.FrogoConstant
import com.frogobox.sdk.delegate.piracy.FrogoPiracyCallback
import com.frogobox.sdk.delegate.piracy.FrogoPiracyDialogCallback
import com.frogobox.sdk.delegate.piracy.PiracyDelegates
import com.frogobox.sdk.delegate.piracy.PiracyDelegatesImpl
import com.frogobox.sdk.delegate.piracy.util.PiracyMessage
import com.frogobox.sdk.ext.startActivityExtOpenApp
import com.frogobox.webview.R
import com.frogobox.webview.common.callback.AdCallback
import com.frogobox.webview.common.ext.APP_IS_DEBUG
import com.google.android.ump.FormError

/**
 * Created by Faisal Amir on 24/10/22
 * -----------------------------------------
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) Frogobox ID / amirisback
 * All rights reserved
 */


abstract class BaseActivity<VB : ViewBinding> : FrogoAdmobBindActivity<VB>(),
    PiracyDelegates by PiracyDelegatesImpl() {

    override fun setupDebugMode(): Boolean {
        return APP_IS_DEBUG
    }

    override fun setupDelegates() {
        super.setupDelegates()
        setupPiracyDelegate(this, this)
        setupPiracyDelegatesDebug(setupDebugMode())
    }

    override fun setupPiracyMode() {
        connectPiracyChecker(object : FrogoPiracyCallback {
            override fun doOnPirated(message: PiracyMessage) {

                showPiracedDialog(message, object : FrogoPiracyDialogCallback {
                    override fun doOnPirated(message: PiracyMessage) {
                        startActivityExtOpenApp("${FrogoConstant.Url.BASE_PLAY_STORE_URL}$packageName")
                    }

                })
            }
        })
    }

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

    fun showUMP(activity: Activity, onAccept: () -> Unit) {
        showAdConsent(object : IFrogoAdConsent {

            override fun activity(): Activity {
                return activity
            }

            override fun isDebug(): Boolean {
                return APP_IS_DEBUG
            }

            override fun isUnderAgeAd(): Boolean {
                return false
            }

            override fun onConsentSuccess() {
                onAccept()
            }

            override fun onNotUsingAdConsent() {
                onAccept()
            }

            override fun onConsentError(formError: FormError) {
                onAccept()
            }

        })
    }

}