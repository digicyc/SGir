package org.antitech.sgir.test

import org.antitech.sgir.Users
import org.scalatest.WordSpec
import org.scalatest.matchers.ShouldMatchers

class UsersTest extends WordSpec with ShouldMatchers {
  "Hate levels when getting/adding hate" should {
    "be equal" in {
      val users = new Users()
      users.addHate("test_user", 5)
      assert(users.getHate("test_user") === 5)
    }
  }
}