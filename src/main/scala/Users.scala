/**
 * User: aaron
 * Date: 2/15/11
 * Time: 4:55 PM
 *
 * Manages users through a mongodb database.
 */
package org.antitech.sgir

import com.mongodb.casbah.Imports._

class Users {
  private val config = Config.config
  private val mongConn = MongoConnection("hazmat.cc")("sgir")
  /*
   * Return TimeStamp and Message that was last said by user.
   */
  def getLastSaid(user: String): String = {
    val mongoColl = mongConn("last_said")
    //val lastSaid = mongoColl.find(MongoDBObject("user" -> user))

    ""
  }

  def saveLastSaid(user: String, msg: String) {
    val mongoColl = mongConn("last_said")
    //mongoColl.save(MongoDBObject(""))
  }

  def addHate(user: String, level: Int) {

  }

  def getHate(user: String): Int = {
    0
  }

  def addPoint(user: String, point: Int) {

  }

  def getPoint(user: String): Int = {
    0
  }
}