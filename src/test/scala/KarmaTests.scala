package antitech.sgir.test

import antitech.sgir.model.MongUser

import org.specs2._

class KarmaTests extends Specification { def is =
  "Testing of handling a User's Karma levels"   ^
                                                p^
  "Karma levels when"                           ^
    "being incremented"                         ! e1^
    "being decremented"                         ! e2^
                                                end

  def e1 = {
    val monguser =
      new MongUser("sgirtest", "sgirtest@localhost.com", List("#sgir"))

    monguser.addKarma(1).get
  } mustEqual 1

  def e2 = pending
}
