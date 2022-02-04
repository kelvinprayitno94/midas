package com.test.midas.koin

import com.test.midas.service.ApiRepository
import com.test.midas.service.ApiRepositoryContract
import org.koin.dsl.module

val apiRepoContractModule = module {
    single<ApiRepositoryContract> {
        ApiRepository(
            apiServices = get()
        )
    }
}
