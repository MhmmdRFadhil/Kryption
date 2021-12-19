package com.ryz.kryption.module

import com.ryz.kryption.ui.MainPresenter
import org.koin.dsl.module

val mainModule = module {
    factory { MainPresenter() }
}