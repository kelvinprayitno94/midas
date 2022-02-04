package com.test.midas.service

import com.test.midas.model.ShopModel
import io.reactivex.Single

interface ApiRepositoryContract {
    fun getList(): Single<ShopModel>
}