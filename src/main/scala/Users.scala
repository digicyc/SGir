/**
 * User: aaron
 * Date: 2/15/11
 * Time: 4:55 PM
 *
 * Manages users through a mongodb database.
 */

import com.mongodb.casbah.Imports._

class Users {
  private val mongConn = MongoConnection("hazmat.cc")("sgir")

  def getLastSaid(user: String): String = {
    val mongoColl = mongConn("last_said")
    val lastSaid = mongoColl.find(MongoDBObject("user" -> user))

    for { x <- lastSaid } yield x
  }

  def saveLastSaid(user: String, msg: String) {
    val mongoColl = mongConn("last_said")
    mongoColl.save(MongoDBObject(""))
  }
}