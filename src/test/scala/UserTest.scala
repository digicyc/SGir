package codeoptimus.sgir.test

/**
 * Test cases for managing our Users.
 */
import codeoptimus.sgir.braincase.UserManagement
import codeoptimus.sgir.braincase.model.IRCUser
import codeoptimus.sgir.braincase.model.MongoConfig

import org.specs2.mutable._
import com.foursquare.rogue.Rogue._

class UserTest extends Specification {
  MongoConfig.init

  "Checking in a 'User'" should {
    "create user if no record found" in {
      val userM = new UserManagement()
      val theyExist =
        userM.checkInUser("testuser", "testhost", "testchannel")

      theyExist.name.is mustEqual "testuser"
    }
    "should use existing user record" in {
      val userCheck =
        IRCUser where (_.name eqs "testuser") get

      userCheck.get.hostname.is mustEqual "testhost"
    }
    "should track all channels we're joined to" in {
      pending
    }
  }
}
