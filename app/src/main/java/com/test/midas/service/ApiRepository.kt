package com.test.midas.service

import com.test.midas.model.ShopModel
import io.reactivex.Single

class ApiRepository(
    private val apiServices: ApiServices
) : ApiRepositoryContract {
    override fun getList(): Single<ShopModel> = apiServices.getList()
}