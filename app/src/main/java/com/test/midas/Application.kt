package com.test.midas

import android.app.Application
import com.test.midas.koin.apiRepoContractModule
import com.test.midas.koin.networkModule
import com.test.midas.koin.viewControllerModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class Application: Application() {
    companion object {
        val modules = listOf(
            viewControllerModule,
            apiRepoContractModule,
            networkModule
        )
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@Application)

            val moduleList = arrayListOf<Module>().apply {
                addAll(modules)
            }

            modules(moduleList)
        }
    }
}