package com.pusauli.utils

import org.springframework.http.HttpStatus


object Constant{



   const val regOK="Registation is create successfully."
   const val regExists="Roll No already exists !!."
   const val dataEmpty="Data is Empty."
   const val shopAvatar="Please select a shopAvatar to upload."

         val OK= HttpStatus.OK
         val CREATED= HttpStatus.CREATED
         val CONFLICT= HttpStatus.CONFLICT
         val NOT_FOUND= HttpStatus.NOT_FOUND
         val emptyArrays=  arrayOf<String>()


}