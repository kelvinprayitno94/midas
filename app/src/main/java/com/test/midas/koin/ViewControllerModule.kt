package com.test.midas.koin

import com.test.midas.ui.HomeActivity
import com.test.midas.ui.HomeViewModel
import com.test.midas.ui.ShopAdapter
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewControllerModule = module {
    scope(named<HomeActivity>()) {
        scoped { ShopAdapter() }
        scoped {
            HomeViewModel(
                apiRepositoryContract = get()
            )
        }
    }
}
