package com.pusauli.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.io.Serializable


@Document(collection="CategoryShop")
data class CategoryShopModel(
        @Id
        var id:Int = 0,
        var categoryId:String? = null,
        var categoryName:String? = null
       )


