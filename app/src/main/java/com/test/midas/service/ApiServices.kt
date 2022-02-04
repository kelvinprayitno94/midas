package com.test.midas.service

import com.test.midas.model.ShopModel
import io.reactivex.Single
import retrofit2.http.GET

interface ApiServices {
    @GET("foodDelivery/dataContent?version=1")
    fun getList(): Single<ShopModel>
}