package antitech.sgir.model

/**
 *  A singleton Object which just establishes a MongoDB connection.
 */

import net.liftweb.mongodb._
import net.lag.configgy.Configgy
import com.mongodb.{Mongo, ServerAddress}

object AdminDb extends MongoIdentifier {
  val jndiName = "admin"
}

object MongoConfig {
  def mUser = Configgy.config("mongo.user")
  def mPass = Configgy.config("mongo.pass")

  def init: Unit = {
    val srvr = new ServerAddress(
      Configgy.config("mongo.host", "127.0.0.1"),
      Configgy.config("mongo.port", 27017)
    )
    MongoDB.defineDb(DefaultMongoIdentifier, new Mongo(srvr), "sgir")
    MongoDB.defineDb(AdminDb, new Mongo(srvr), "admin")
  }
}