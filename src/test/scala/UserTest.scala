package antitech.sgir.test

/**
 * Test cases for managing our Users.
 */

import org.specs2.mutable._

import antitech.sgir.model.MongoConfig.initTest

class UserTest extends Specification {
  "A user" should {
    "be added if not" in {
      initTest

    }
  }
}