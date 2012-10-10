package commands

import codeoptimus.sgir.comm.IRCPacket

/**
 *
 * Created with IntelliJ IDEA.
 * User: Aaron Allred
 */
object Command {
  def recvMsg(ircPacket: IRCPacket) {
    ircPacket.msg
  }

  // Parse out the message sent for any possible commands.
  def parseCommand(msg: String): (String, String) = {
    val command = msg.split(" ").head.toLowerCase
    val argument = msg.replace(command + " ", "")

    (command, argument)
  }

  // Take first part as command and rest as Arguments sent.
  def parseArguments(msg: String): (String, List[String]) = {
    val command = msg.split(" ").head.toLowerCase
    val arguments = msg.split(" ").drop(1).toList

    (command, arguments)
  }

}
