package codeoptimus.sgir.test.comm

/**
 * 
 * Created with IntelliJ IDEA.
 * User: Aaron Allred
 */

import codeoptimus.sgir.comm.IRCPacket
import org.specs2.mutable._

class IRCPacketTest extends Specification {
  private val ircPacket = IRCPacket("#test", "testSender", "testLogin", "hostHost", "My msg")

  "The creation of an IRCPacket" should {
    "contain similar msg that's sent" in {
      ircPacket.msg mustEqual "My msg"
    }

    "contain correct channel sent" in {
      ircPacket.chan mustEqual "#test"
    }
  }
}
