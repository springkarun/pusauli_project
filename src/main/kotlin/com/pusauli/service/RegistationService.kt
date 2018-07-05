package com.pusauli.service

import com.pusauli.model.RegistationModel


interface RegistationService {

      fun findByRollNo(rollNo: String): Any

      fun saveStudent(studentModel: RegistationModel):Any

      fun showAllStudent():Any


}
