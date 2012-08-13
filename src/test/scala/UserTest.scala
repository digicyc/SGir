package codeoptimus.sgir.test

/**
 * Test cases for managing our Users.
 */
import codeoptimus.sgir.braincase.UserManagement

import org.specs2.mutable._

class UserTest extends Specification {
  "Checking in a 'User'" should {
    "create user if no record found" in {
      val userM = new UserManagement()
      val user = userM.checkInUser("testuser", "testhost", "testchannel")
    }
    "should use existing user record" in {
      pending
    }
    "should track all channels we both are in" in {
      pending
    }
  }
}
