package antitech.sgir.model

/**
 *  A singleton Object which just establishes a MongoDB connection.
 */

import net.liftweb.mongodb._
import net.lag.configgy.Configgy
import com.mongodb.{ServerAddress, Mongo}


object MongoConfig {
  def mUser = Configgy.config("mongo.user")
  def mPass = Configgy.config("mongo.pass")

  def init: Unit = {
    val srvr = new ServerAddress(
      Configgy.config("mongo.host", "127.0.0.1"),
      Configgy.config("mongo.port", 27017)
      )
    MongoDB.defineDb(DefaultMongoIdentifier, new Mongo(srvr), "sgir")
  }
  
  def initTest = {
    val srvr = new ServerAddress(
      Configgy.config("test.mongo.host", "127.0.0.1"),
      Configgy.config("test.mongo.port", 27017)
    )
    MongoDB.defineDb(DefaultMongoIdentifier, new Mongo(srvr), "testsgir")
  }
}