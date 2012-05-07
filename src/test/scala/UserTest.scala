package antitech.sgir.test

/**
 * Test cases for managing our Users.
 */

import org.specs2._

class UserTest extends Specification { def is =
  "Check User activity and User handling"     ^
                                              p^
  "The User should"                           ^
    "be created if not already"               ! e1^
    "contain permissions"                     ! e2^
    "Have a Karma level of 0"                 ! e3^
                                              end


  def e1 = {

  } pending
  def e2 = pending
  def e3 = pending
}