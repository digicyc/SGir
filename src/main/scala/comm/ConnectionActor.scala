package codeoptimus.sgir.comm

import akka.actor.{ActorLogging, Actor}
import comm.Reconnect

/**
 * 
 * Created with IntelliJ IDEA.
 * User: Aaron Allred
 */

class ConnectionActor extends Actor with ActorLogging {
  def receive = {
    case reconnect: Reconnect =>
      None
    case _ => None
  }
}
