package antitech.sgir.model

import com.mongodb.casbah.Imports._

case class User()

class UserMong {
  private val mongoConn = MongoConnection()
  private val coll = mongoConn("sgir")("users")

  def getUser(alias: String): Option[UserMong] = {
    None
  }

  def checkInUser(user: String) = {
    false
  }

  def addKarma(user: String): Option[Int] = {
    Option(0)
  }

  def subKarma(user: String): Option[Int] = {
    Option(0)
  }

}
