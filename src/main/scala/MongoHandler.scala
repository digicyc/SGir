package org.antitech.sgir
/**
 * User: digicyc
 * Date: 3/24/11
 * Time: 1:30 AM
 * 
 */
import com.mongodb.casbah.Imports._

object MongoHandler {
  private val mongConn = MongoConnection("hazmat.cc")("sgir")

  def getHateColl() = mongConn("hate")

  def getPointColl() = mongConn("point")
}