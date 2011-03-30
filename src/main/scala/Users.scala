/**
 * User: aaron
 * Date: 2/15/11
 * Time: 4:55 PM
 *
 * User object created for each user in a channel.
 */
package org.antitech.sgir

import com.mongodb.casbah.Imports._
import java.text.SimpleDateFormat
import java.util.Date

class User(val name: String, val host: String) {
  private val config = Config.config
  private var _lastSaid = ""


  def lastSaid = _lastSaid

  /*
   * Don't store in DB cause were not creepy like that.
   */
  def lastSaid_=(msg: String) =
    _lastSaid = "[" + new Date + "]: " + msg


  /*
   * We assume user object always exists.
   * Increment the Hate level of a user.
   */
  def addHate(level: Int) {
    val hateColl = MongoHandler.getHateColl()
    val userObj = MongoDBObject("host" -> host)

    val userData = hateColl.find(userObj)
    // userData now has a Cursor object
    
  }

  def getHate(): Int = {
    5
  }

  /*
   * Increment Karma level
   */
  def addKarma(point: Int) {

  }

  def getKarma(): Int = {
    0
  }
}
