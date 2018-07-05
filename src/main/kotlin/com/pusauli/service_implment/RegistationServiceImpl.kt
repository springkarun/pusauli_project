package com.pusauli.service_implment

import com.pusauli.utils.Constant.CONFLICT
import com.pusauli.utils.Constant.CREATED
import com.pusauli.utils.Constant.emptyArrays
import com.pusauli.utils.Constant.regExists
import com.pusauli.utils.Constant.regOK
import com.pusauli.model.RegistationModel
import com.pusauli.model.ResponseModel
import com.pusauli.repository.RegistationRepository
import com.pusauli.service.RegistationService
import com.pusauli.utils.Constant.OK
import com.pusauli.utils.Constant.dataEmpty
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service


@Service("registationService")
class RegistationServiceImpl : RegistationService {

    @Autowired
    private val regRepo: RegistationRepository? = null


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
    }
}





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


