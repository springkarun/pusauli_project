package com.pusauli.repository

import com.pusauli.model.RegisterShopModel
import org.springframework.data.mongodb.repository.MongoRepository


interface RegisterShopRepository : MongoRepository<RegisterShopModel, Int> {



  //  @Query(value="{ 'firstname' : ?0 }", fields="{ 'firstname' : 1, 'lastname' : 1}")
   // @Query(value = "{ 'brand' : ?0}")
  //  @Query(value = "{'_id':'MC6684'},{'password':'kk534'}")
   // @Query("{'$or':[ {'A':10}, {'B':20} ] }")

  //  @Query("{passwords : ?0}")
  //  fun findByPassword(passwords: String):List<RegistationModel>*/

}
