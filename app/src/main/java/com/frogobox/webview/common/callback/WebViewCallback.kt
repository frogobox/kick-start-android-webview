package com.frogobox.webview.common.callback

/**
 * Created by Faisal Amir on 24/10/22
 * -----------------------------------------
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) Frogobox ID / amirisback
 * All rights reserved
 */

interface WebViewCallback {

    fun onShowProgress()

    fun onHideProgress()

    fun onFinish()

    fun onFailed()

}