package antitech.sgir.model

/**
 *  A singleton Object which just establishes a MongoDB connection.
 */

import net.liftweb.mongodb._
import net.lag.configgy.Configgy
import com.mongodb.casbah.MongoDB
import com.mongodb.{Mongo, ServerAddress}

object AdminDb extends MongoIdentifier {
  val jndiName = "admin"
}

object MongoConfig {
  def mUser = Configgy.getString("mongo.user")
  def mPass = Configgy.getString("mongo.pass")

  def init: Unit = {
    val srvr = new ServerAddress(
      Configgy.getString("mongo.host", "127.0.0.1"),
      Configgy.getInt("mongo.port", 27017)
    )
    MongoDB.defineDb(DefaultMongoIdentifier, new Mongo(srvr), "sgir")
    MongoDB.defineDb(AdminDb, new Mongo(src), "admin")
  }
}