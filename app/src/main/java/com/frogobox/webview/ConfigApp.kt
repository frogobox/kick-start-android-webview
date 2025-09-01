package com.frogobox.webview

import com.frogobox.webview.ui.util.sampleHtmlText

/**
 * Created by Faisal Amir on 24/10/22
 * -----------------------------------------
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) Frogobox ID / amirisback
 * All rights reserved
 */


object ConfigApp {

    /**
     * Link for your Website
     */
    const val URL_LINK_WEBSITE = "https://github.com/amirisback"

    /**
     * Inline your html text string
     */
    const val URL_LINK_DATA = sampleHtmlText

    /**
     * Set Your Server Domain
     */
    const val URL_WEB = URL_LINK_WEBSITE


    object Flag {

        /*
            Flag for toggle ads
            turn on = true
            turn off = false
         */

        const val IS_USING_AD_INTERSTITIAL = true
        const val IS_USING_AD_BANNER = true
    }

}