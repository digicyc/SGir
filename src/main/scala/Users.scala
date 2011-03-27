/**
 * User: aaron
 * Date: 2/15/11
 * Time: 4:55 PM
 *
 * Manages users through a mongodb database.
 */
package org.antitech.sgir

import com.mongodb.casbah.Imports._
import java.text.SimpleDateFormat
import java.util.Date

class User(val name: String, val host: String) {
  private val config = Config.config
  var lastSaid = ""

  /*
   * Don't store in DB cause were not creepy like that.
   */
  def setLastSaid(msg: String) =
    lastSaid = "[" + new Date + "]: " + msg


  def addHate(level: Int) {
    val hateObj = MongoDBOBject("user" -> name)
    
  }

  def getHate(): Int = {
    5
  }

  def addPoint(point: Int) {

  }

  def getPoint(): Int = {
    0
  }
}