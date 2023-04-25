package com.frogobox.webview.common.core

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.frogobox.sdk.view.FrogoBindFragment

/**
 * Created by Faisal Amir on 24/10/22
 * -----------------------------------------
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) Frogobox ID / amirisback
 * All rights reserved
 */


abstract class BaseFragment<VB : ViewBinding> : FrogoBindFragment<VB>() {

    protected lateinit var mBaseActivity: BaseActivity<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBaseActivity = (activity as BaseActivity<*>)
    }

}