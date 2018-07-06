package com.pusauli.service


interface CategoryShopService {

    fun saveCategoryShop(categoryId :String, categoryName :String):Any
    fun showAllCategory():Any

}
