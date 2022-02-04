package com.test.midas.model

import com.google.gson.annotations.SerializedName

data class ShopModel(
    @SerializedName("payload" ) var payload : ArrayList<Payload> = arrayListOf(),
    @SerializedName("errors"  ) var errors  : ArrayList<String>  = arrayListOf(),
    @SerializedName("success" ) var success : Boolean?           = null
)

data class Menus (

    @SerializedName("code"      ) var code      : Int?    = null,
    @SerializedName("title"     ) var title     : String? = null,
    @SerializedName("ind"       ) var ind       : String? = null,
    @SerializedName("eng"       ) var eng       : String? = null,
    @SerializedName("price"     ) var price     : Int?    = null,
    @SerializedName("discPrice" ) var discPrice : Int?    = null,
    @SerializedName("image"     ) var image     : String? = null

)

data class Shop (

    @SerializedName("code"     ) var code     : Int?             = null,
    @SerializedName("shopName" ) var shopName : String?          = null,
    @SerializedName("address"  ) var address  : String?          = null,
    @SerializedName("image"    ) var image    : String?          = null,
    @SerializedName("Menus"    ) var Menus    : ArrayList<Menus> = arrayListOf()

)

data class Payload (

    @SerializedName("shop" ) var shop : ArrayList<Shop> = arrayListOf()

)