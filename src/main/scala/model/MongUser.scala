package antitech.sgir.model

import com.mongodb.casbah.Imports._

class MongUser(name: String, host: String, channels: List[String]) {
  private val mongoConn = MongoConnection()
  private val coll = mongoConn("sgir")("users")
  private val user = MongoDBObject(
    "name" -> name,
    "hostname" -> host,
    "channels" -> channels
  )

  // write to database our user
  private val res = coll.findOne(user)
  if(res == None)
    coll += user

  private def getUser =
    coll.findOne(MongoDBObject("_id" -> user.get("_id"))).get

  def checkInUser(channel: String) = {
    List(channel) ::: channels
  }

  def addKarma(amount: Int): Option[Int] = {
    coll.update(getUser, $inc("karma" -> amount))
    Option(0)

  }

  def subKarma(amount: Int): Int = {
    //coll.update(getUser, $dec("karma" -> amount))
    0
  }

  def getKarma: Int = {
    user.getAs[Int]("karma").get
  }

}
