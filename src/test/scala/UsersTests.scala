package org.antitech.sgir.test

import org.antitech.sgir.User
import org.scalatest.WordSpec
import org.scalatest.matchers.ShouldMatchers

class UserTest extends WordSpec with ShouldMatchers {
  "Hate levels when getting/adding hate" should {
    "be incremented" in {
      val user = new User("test_user", "test.host.com")
      user.reset() // Reset Hate level to 0
      user.addHate(5)
      assert(user.getHate() === 5)
      user.addHate(2)
      assert(user.getHate() === 7)
      // It should just increment the Hate level
    }
  }

  "Karma levels when adding/getting" should {
    "be incremented" in {
      val user = new User("test_user", "test.host.com")
      user.addKarma(0)
    }
  }
}