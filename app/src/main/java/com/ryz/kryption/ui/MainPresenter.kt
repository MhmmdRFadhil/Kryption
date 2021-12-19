package com.ryz.kryption.ui

class MainPresenter {
    private var view: MainView? = null

    fun attachView(view: MainView) {
        this.view = view
    }

    fun check(text: String) {
        if (text.isEmpty()) {
            view?.onPlainTextEmpty()
        }
    }
}