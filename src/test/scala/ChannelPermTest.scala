/**
 * Test Channel Permisions.
 * channel_perm = {"#chan" -> "ops"} = Has Ops
 */

import org.specs2.mutable._

import antitech.sgir.model.User
import antitech.sgir.model.MongoConfig.initTest
import com.foursquare.rogue.Rogue._

class ChannelPermTest extends Specification {
  // Initalize the test DB
  initTest

  // Our Test User
  val newUser = User.createRecord.alias("TestUser")
  newUser.channel_perms("#testchan") = OPS
  newUser.save
  
  "A person with ops" should {
    "have it set" in {
      val user = 
        User where (_.alias eqs "TestUser") get
      user.get.channel_perms("#testchan").get mustEqual OPS
    }
  }
}