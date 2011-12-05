package antitech.sgir

/**
 * Handles all messages.
 */

import actors.Actor

import antitech.sgir.Handles._

object MessageActor extends Actor {
  def act() {
    receive {
      case Message(chan, sender, login, host, msg) =>
        println("Received Message: " + msg)
    }
  }
}