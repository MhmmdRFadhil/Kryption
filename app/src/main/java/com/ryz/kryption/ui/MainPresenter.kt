package com.ryz.kryption.ui

import android.view.View
import android.widget.ImageView

class MainPresenter {
    private var view: MainView? = null

    fun attachView(view: MainView) {
        this.view = view
    }

    fun check(text: String, copy: ImageView) {
        if (text.isEmpty()) {
            view?.onPlainTextEmpty()
            copy.visibility = View.GONE
        } else {
            copy.visibility = View.VISIBLE
        }
    }
}