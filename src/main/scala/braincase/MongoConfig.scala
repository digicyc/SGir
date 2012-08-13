package codeoptimus.sgir.model

/**
 *  A singleton Object which just establishes a MongoDB connection.
 */

import net.liftweb.mongodb._
import com.mongodb.{ServerAddress, Mongo}


object MongoConfig {
  def mUser = ""
  def mPass = ""

  def init = {
    val srvr = new ServerAddress("127.0.0.1", 27017)
    MongoDB.defineDb(DefaultMongoIdentifier, new Mongo(srvr), "sgir")
  }
  
  def initTest = {
    val srvr = new ServerAddress("127.0.0.1", 27017)
    MongoDB.defineDb(DefaultMongoIdentifier, new Mongo(srvr), "testsgir")
  }
}
