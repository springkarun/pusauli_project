package com.pusauli.service_implment

import com.pusauli.model.RegisterShopModel
import com.pusauli.model.ResponseModel
import com.pusauli.repository.RegisterShopRepository
import com.pusauli.service.RegisterShopService
import com.pusauli.utils.Constant
import com.pusauli.utils.Constant.emptyArrays
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*


@Service("registerShopService")
class RegistarShopServiceImpl : RegisterShopService {



    private val UPLOADED_FOLDER = "E:\\Spring\\Pusauli\\imagesUpload\\bank\\"
    @Autowired
    private val regRepo: RegisterShopRepository? = null


    override fun saveRegisterShop(categoryId :String,shopId: String, shopName: String, shopReg: String, shopAvatar: MultipartFile,
                                  shopEmail: String, shopMobile: String, shopAddress: String, shopNearst: String,
                                  shopTime: String, shopRating: String, shopLatitude: String, shopLongitude: String,
                                  ownerName: String, ownerEmail: String, ownerContact: String,
                                  ownerAvatar: MultipartFile, colorCode: String, reg_date: String): Any {

        if (shopAvatar.isEmpty) {
            return ResponseEntity(ResponseModel(false, Constant.shopAvatar, emptyArrays), Constant.NOT_FOUND)
        }

        if (ownerAvatar.isEmpty) {
            return ResponseEntity(ResponseModel(false, Constant.shopAvatar, emptyArrays), Constant.NOT_FOUND)
        }

        val timestamp = Calendar.getInstance().timeInMillis.toString()

        val shopAvatarPath =  timestamp+"_"+shopAvatar.originalFilename

        try {
            val bytes = shopAvatar.bytes
            val path = Paths.get(UPLOADED_FOLDER+shopAvatarPath)
            Files.write(path, bytes)
        } catch (e: IOException) { e.printStackTrace() }


        val ownerAvatarPath = timestamp+"_"+ownerAvatar.originalFilename
        try {
            val bytes = ownerAvatar.bytes
            val path = Paths.get(UPLOADED_FOLDER+ownerAvatarPath)
            Files.write(path, bytes)
        } catch (e: IOException) { e.printStackTrace() }

        var randamValues=(Math.random()*10000).toInt()
        regRepo!!.save(RegisterShopModel(randamValues,categoryId,shopId, shopName, shopReg, shopAvatarPath, shopEmail, shopMobile,
                shopAddress, shopNearst, shopTime, shopRating, shopLatitude, shopLongitude, ownerName, ownerEmail,
                ownerContact, ownerAvatarPath, colorCode, reg_date))

        val res = regRepo.findAll()
        return ResponseEntity(ResponseModel(true, Constant.regOK, res), Constant.CREATED)

    }

    override fun getPhoto(path: String): ResponseEntity<ByteArray> {
        val imgPath = File(UPLOADED_FOLDER+path)
        val image = Files.readAllBytes(imgPath.toPath())
        val headers = HttpHeaders()
        headers.contentType = MediaType.IMAGE_JPEG
        headers.contentLength = image.size.toLong()
        return ResponseEntity(image, headers, HttpStatus.OK)
    }

    override fun showAllShop(): Any {
        val res=regRepo!!.findAll().reversed()
        if(res.isNotEmpty())
            return  ResponseEntity(ResponseModel(true, "Total Size : ${res.size}",res), Constant.OK)
        else  return ResponseEntity(ResponseModel(false, Constant.dataEmpty,emptyArrays), Constant.OK)
    }
}


/*
    override fun saveStudent(studentModel: RegistationModel): Any {
        val id = regRepo!!.existsById(studentModel.rollNo!!)
        return if (!id) {
            regRepo.save(studentModel)
            val res=regRepo.findByRollNo(studentModel.rollNo!!)
            ResponseEntity(ResponseModel(true, regOK,res),CREATED )
        } else
            ResponseEntity(ResponseModel(false, regExists,emptyArrays),CONFLICT)
      }

    override fun findByRollNo(rollNo: String):Any {
        val res=regRepo!!.findByRollNo(rollNo)
        if(res.isNotEmpty())
            return  ResponseEntity(ResponseModel(true, "Total Size : ${res.size}",res),OK )
        else  return ResponseEntity(ResponseModel(false, dataEmpty,emptyArrays), OK)
    }


    override fun showAllStudent(): Any {
        val res=regRepo!!.findAll().reversed()
        if(res.isNotEmpty())
        return  ResponseEntity(ResponseModel(true, "Total Size : ${res.size}",res),OK )
        else  return ResponseEntity(ResponseModel(false, dataEmpty,emptyArrays), OK)
    }*/






    /*


     override fun findUserByEmail(email: String): RegistationModel {
         return regRepo!!.findByEmail(email)
     }*/


   /* fun saveUser(user: RegistationModel) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()))
        user.setActive(1)
        val userRole = roleRepository!!.findByRole("ADMIN")
        user.setRoles(HashSet<Role>(Arrays.asList<Any>(userRole)))
        userRepository!!.save(user)
    }*/


