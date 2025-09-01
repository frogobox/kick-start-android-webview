/**
 * Created by faisalamir on 19/09/21
 * FrogoRecyclerView
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.
 * All rights reserved
 *
 */

object ProjectSetting {
    // project settings
    const val NAME_APP = "WebView"

    // Change This
    // Sample : com.[yourcompanyname].[yourprojectname]
    // Sample : com.frogobox.webview
    const val PROJECT_APP_ID = "com.github.amirisback.web" // Change With Your Own

    const val VERSION_MAJOR = 2
    const val VERSION_MINOR = 0
    const val VERSION_PATCH = 1

    // Key Store
    const val PLAYSTORE_STORE_FILE = "keystore/frogoboxmedia.jks"
    const val PLAYSTORE_STORE_PASSWORD = "amirisback"
    const val PLAYSTORE_KEY_ALIAS = "frogoisback"
    const val PLAYSTORE_KEY_PASSWORD = "amirisback"

    // ---------------------------------------------------------------------------------------------
    // Do Not Change This Below
    // ---------------------------------------------------------------------------------------------

    const val PROJECT_MIN_SDK = 23
    const val PROJECT_COMPILE_SDK = 36
    const val PROJECT_TARGET_SDK = PROJECT_COMPILE_SDK

    val NAME_APK = NAME_APP.lowercase().replace(" ", "-")
    const val PROJECT_NAME_SPACE = "com.frogobox.webview"
    const val PROJECT_VERSION_CODE = (VERSION_MAJOR * 100) + (VERSION_MINOR * 10) + (VERSION_PATCH * 1)
    const val PROJECT_VERSION_NAME = "$VERSION_MAJOR.$VERSION_MINOR.$VERSION_PATCH"

    // Declaration apps name debug mode
    const val debugAttribute = "DEV"
    const val nameAppDebug = "$NAME_APP $debugAttribute"

}