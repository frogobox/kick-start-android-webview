package com.frogobox.webview.ui.main

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.frogobox.coresdk.util.FrogoConstant
import com.frogobox.sdk.ext.gone
import com.frogobox.sdk.ext.startActivityExtOpenApp
import com.frogobox.sdk.ext.visible
import com.frogobox.webview.ConfigApp
import com.frogobox.webview.ConfigApp.URL_WEB
import com.frogobox.webview.common.callback.AdCallback
import com.frogobox.webview.common.callback.WebViewCallback
import com.frogobox.webview.common.core.BaseActivity
import com.frogobox.webview.common.ext.APP_ID
import com.frogobox.webview.common.ext.loadUrlExt
import com.frogobox.webview.databinding.ActivityMainBinding
import com.frogobox.webview.databinding.DialogRatingAppBinding


class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun setupViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreateExt(savedInstanceState: Bundle?) {
        super.onCreateExt(savedInstanceState)
        showUMP(this) {
            setupFlagAd()
        }
        setupFlagAd()
    }

    override fun doOnBackPressedExt() {
        if (binding.mainWebview.canGoBack()) {
            binding.mainWebview.goBack()
        } else {
            showDialog()
        }

    }

    private fun setupFlagAd() {
        if (ConfigApp.Flag.IS_USING_AD_INTERSTITIAL) {
            setupAd()
        } else {
            setupUI()
        }
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

    private fun setupLoadWeb() {
        binding.apply {
            mainWebview.loadUrlExt(url = URL_WEB, callback = object : WebViewCallback {

                override fun onShowProgress() {
                    containerProgressView.progressView.visible()
                }

                override fun onHideProgress() {
                    containerProgressView.progressView.gone()
                }

                override fun onFinish() {
                    containerFailedView.failedView.gone()
                    if (ConfigApp.Flag.IS_USING_AD_BANNER) {
                        adsView.adsPhoneTabSpecialSmartBanner.visible()
                        showAdBanner(adsView.adsPhoneTabSpecialSmartBanner)
                    } else {
                        adsView.adsPhoneTabSpecialSmartBanner.gone()
                    }
                }

                override fun onFailed() {
                    // Activate this if you want failed view
                    // containerFailedView.failedView.visible()
                }

            })
        }
    }

    private fun setupUI() {
        binding.apply {

            containerFailedView.ivClose.setOnClickListener {
                containerFailedView.failedView.gone()
                setupLoadWeb()
            }

            setupLoadWeb()
        }

    }

    private fun showDialog() {
        val dialogBinding = DialogRatingAppBinding.inflate(layoutInflater, null, false)
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setView(dialogBinding.root)

        dialogBinding.apply {
            btnRate.setOnClickListener { rateApp() }
            btnExit.setOnClickListener { exitApp() }
        }

        val alertDialog = dialogBuilder.create()
        alertDialog.show()
    }

    private fun rateApp() {
        startActivityExtOpenApp("${FrogoConstant.Url.BASE_PLAY_STORE_URL}${APP_ID}")
    }

    private fun exitApp() {
        finishAffinity()
    }

}