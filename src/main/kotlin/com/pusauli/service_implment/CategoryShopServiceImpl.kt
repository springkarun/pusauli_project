package com.pusauli.service_implment

import com.pusauli.model.CategoryShopModel
import com.pusauli.model.ResponseModel
import com.pusauli.repository.CategoryShopRepository
import com.pusauli.service.CategoryShopService
import com.pusauli.utils.Constant
import com.pusauli.utils.Constant.CREATED
import com.pusauli.utils.Constant.category
import com.pusauli.utils.Constant.emptyArrays
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service


@Service("categoryShopService")
class CategoryShopServiceImpl : CategoryShopService {



    @Autowired
    private val regRepo: CategoryShopRepository? = null


    override fun saveCategoryShop(categoryId: String, categoryName: String): Any {
            val randamValues=(Math.random()*10000).toInt()
            regRepo!!.save(CategoryShopModel(randamValues,categoryId+randamValues,categoryName))
            val res=regRepo.findAll().reverse()
            return  ResponseEntity(ResponseModel(true, category,res),CREATED )
    }

    override fun showAllCategory(): Any {
        val res=regRepo!!.findAll().reversed()
        if(res.isNotEmpty())
            return  ResponseEntity(ResponseModel(true, "Total Size : ${res.size}",res), Constant.OK)
        else  return ResponseEntity(ResponseModel(false, Constant.dataEmpty,emptyArrays), Constant.OK)
    }
}

