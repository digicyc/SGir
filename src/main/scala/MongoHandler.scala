/**
 * User: digicyc
 * Date: 3/24/11
 * Time: 1:30 AM
 * 
 */
package org.antitech.sgir

import com.mongodb.casbah.Imports._

object MongoHandler {
  private val mongConn = MongoConnection("hazmat.cc")("sgir")
  mongConn.authenticate("sgir", "inv4derZim")

  def getHateColl() = mongConn("hate")

  def getPointColl() = mongConn("point")
}