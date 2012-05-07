package antitech.sgir.model

import com.mongodb.casbah.Imports._

class MongUser(name: String, host: String, channels: List[String]) {
  private val mongoConn = MongoConnection()
  private val coll = mongoConn("sgir")("users")
  private val user = MongoDbObject(
    "name" -> name,
    "hostname" -> host,
    "channels" -> channels
  )

  // write to database our user
  val res = coll.findOne(user)
  if((coll.find(user)).length < 0)
    coll += user

  private def getUser =
    coll.findOne(MongoDBObject("_id" -> user.get("_id"))).get

  def checkInUser(channel: String) = {
    List(channel) ::: channels
  }

  def addKarma(amount: Int): Option[Int] = {
    coll.update(pfid, $inc("karma", amount))
    Option(0)

  }

  def subKarma(user: String): Int = {
    coll.update()
  }

  def getKarma: Int = {
    user("karma")
  }

}
