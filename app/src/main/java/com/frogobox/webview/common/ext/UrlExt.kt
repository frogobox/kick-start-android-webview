package com.frogobox.webview.common.ext

import android.util.Patterns

/**
 * Created by faisalamircs on 01/09/2025
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


fun String.validateUrl(): String {
    return if (this.contains("http://") || this.contains("https://") || this.isValidUrl()) {
        this
    } else {
        "https://$this"
    }
}

fun String.isValidUrl(): Boolean {
    return Patterns.WEB_URL.matcher(this).matches()
}
