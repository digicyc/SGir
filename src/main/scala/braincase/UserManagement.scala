package codeoptimus.sgir.braincase

import model.IRCUser

import com.foursquare.rogue.Rogue._

class UserManagement {
  /**
   * Check a User into MongoDB
   */
  def checkInUser(name: String, host: String, channel: String) = {
    val user =
      IRCUser where (_.name eqs name) get

    if(user == None) {
      // If user doesn't exist lets create them.
      val newUser = IRCUser.createRecord
        .name(name)
        .hostname(host)
        .channels(List(channel))
        .save

      newUser
    } else {
      user.get
    }
  }

  /**
   * Add Karma to username.
   */
  def addKarma(name: String, amount: Int): Option[Int] = {
    val user = 
      IRCUser where (_.name eqs name) modify (_.karma inc amount)

    Option(0)
  }

  /**
   * Get Karma amount for user.
   */
  def getKarma(name: String): Int = {
    val user =
      IRCUser where (_.name eqs name) get

    0
  }

}
