package org.antitech.sgir.test

import org.antitech.sgir.User
import org.scalatest.WordSpec
import org.scalatest.matchers.ShouldMatchers

class UserTest extends WordSpec with ShouldMatchers {
  "Hate levels when getting/adding hate" should {
    "be equal" in {
      val user = new User("test_user", "test.host.com")
      user.addHate(5)
      assert(user.getHate() === 5)
    }
  }
}