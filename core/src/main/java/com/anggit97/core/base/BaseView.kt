package com.anggit97.core.base

/**
 * Created by Anggit PRayogo on 2019-08-13.
 * github : @anggit97
 */
interface BaseView {
    fun onMessage(message: String?)
    fun onMessage(stringResId: Int)
    fun isNetworkConnect(): Boolean
    fun hideKeyboard()
}