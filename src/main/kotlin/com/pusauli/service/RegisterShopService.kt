package com.pusauli.service

import org.springframework.http.ResponseEntity
import org.springframework.web.multipart.MultipartFile


interface RegisterShopService {

      fun saveRegisterShop(categoryId :String, shopName :String, shopReg :String, shopAvatar: MultipartFile,
                           shopEmail :String, shopMobile :String, shopAddress :String,
                           shopNearst :String, shopTime :String, shopRating :String, shopLatitude :String,
                           shopLongitude :String, ownerName :String, ownerEmail :String, ownerContact :String,
                           ownerAvatar :MultipartFile, colorCode :String):Any


        fun getPhoto(path:String): ResponseEntity<ByteArray>

        fun showAllShop():Any

}
