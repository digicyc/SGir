package antitech.sgir.model

import com.mongodb.casbah.Imports._

class UserManagement {
  // TODO: Decide to pass in User object or keep as Global Object.

  /**
   * Check a User into MongoDB
   */
  def checkInUser(name: String, host: String, channel: String) = {
    val user =
      User where (_name.name eqs name) get

    if(user == None) {
      // If user doesn't exist lets create them.
      val newUser = User.createRecord()
        .name(name)
        .hostname(host)
        .channels(List(channel))
        .save

      newUser
    } else {
      user.get.is
    }
  }

  /**
   * Add Karma to username.
   */
  def addKarma(name: String, amount: Int): Option[Int] = {
    val user = 
      User where (_.name eqs name) modify (_.karma inc amount)
  }

  /**
   * Get Karma amount for user.
   */
  def getKarma(name: String): Int = {

  }

}
