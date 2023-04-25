package com.frogobox.webview.ui.main

import android.os.Bundle
import com.frogobox.sdk.ext.gone
import com.frogobox.sdk.ext.visible
import com.frogobox.webview.ConfigApp.URL_LINK_WEBSITE
import com.frogobox.webview.common.callback.AdCallback
import com.frogobox.webview.common.callback.WebViewCallback
import com.frogobox.webview.common.core.BaseActivity
import com.frogobox.webview.common.ext.loadUrlExt
import com.frogobox.webview.databinding.ActivityMainBinding


class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun setupViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreateExt(savedInstanceState: Bundle?) {
        super.onCreateExt(savedInstanceState)
        setupAd()
    }

    private fun setupAd() {
        showInterstitial(object : AdCallback {

            override fun onShowProgress() {
                binding.containerProgressView.progressView.visible()
            }

            override fun onHideProgress() {
                binding.containerProgressView.progressView.gone()
            }

            override fun onFinish() {
                setupUI()
            }

            override fun onFailed() {
                setupUI()
            }

        })
    }

    private fun setupUI() {
        binding.apply {

            mainWebview.loadUrlExt(URL_LINK_WEBSITE, object : WebViewCallback {

                override fun onShowProgress() {
                    containerProgressView.progressView.visible()
                }

                override fun onHideProgress() {
                    containerProgressView.progressView.gone()
                }

                override fun onFinish() {
                    containerFailedView.failedView.gone()
                    showAdBanner(adsView.adsPhoneTabSpecialSmartBanner)
                }

                override fun onFailed() {
                    containerFailedView.failedView.visible()
                }

            })
        }
    }

}