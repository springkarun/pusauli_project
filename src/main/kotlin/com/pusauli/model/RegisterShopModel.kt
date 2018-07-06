package com.pusauli.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.io.Serializable


@Document(collection="RegisterShop")
data class RegisterShopModel(
        @Id
        var id:Int = 0,
        var categoryId:String? = null,
        var shopId:String? = null,
        var shopName:String? = null,
        var shopReg:String? = null,
        var shopAvatar:String? = null,
        var shopEmail:String? = null,
        var shopMobile:String? = null,
        var shopAddress:String? = null,
        var shopNearst:String? = null,
        var shopTime:String? = null,
        var shopRating:String? = null,
        var shopLatitude:String? = null,
        var shopLongitude:String? = null,
        var ownerName:String? = null,
        var ownerEmail:String? = null,
        var ownerAvatar:String? = null,
        var ownerContact:String? = null,
        var colorCode:String? = null,
        var reg_date:String? = null
):Serializable


