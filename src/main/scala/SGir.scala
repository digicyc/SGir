package org.antitech.sgir

import org.jibble.pircbot.PircBot

class SGir extends PircBot {
  private val config = Config.config
  private val botName: String = config.getString("botName")
  private val adminHost: String = config.getString("adminHost")
  private val socPrint: SocPrint = new SocPrint

  setName(botName)
  setLogin(botName)

  // Is called whenever any message is sent.
  override def onMessage(chan: String, sender: String,
          login: String, host: String, 
          msg: String): Unit = 
  {
    // = Commands are for Admin and Control.
    if (msg.startsWith("=") && isAdminHost(host)) {
      // First check hostname in order to allow commands.
      val command = msg.split(" ").head.toLowerCase
      val arguments = msg.split(" ").drop(1).toList

      command match {
        case "=join" =>
          joinChannel(arguments.head)
        case "=say" => sendMessage(chan, 
          arguments.reduceLeft[String] {(y, z) => y + " " + z} )
        case "=exit" => System.exit(1)
        case "=reverse" => sendMessage(chan,
          arguments.reduceLeft[String] {(y, z) => z + " " + y} )
        case "=print" =>
          arguments.head.toLowerCase match {
            case "stats" =>
              arguments.tail.head match {
                case "2panel" =>
                  val statSheet = socPrint.getStats("2panel")
                  statSheet.foreach((x) => 
                    sendMessage(chan, "2Panel: " + x._1 + ": " + x._2)) 
                case "3panel" =>
                  val statSheet = socPrint.getStats("3panel")
                  statSheet.foreach((x) => 
                    sendMessage(chan, "3Panel: " + x._1 + ": " + x._2))
                case "postcard" =>
                  val statSheet = socPrint.getStats("postcard")
                  statSheet.foreach((x) => 
                    sendMessage(chan, "PostCard: " + x._1 + ": " + x._2)) 
                case "all" =>
                  socPrint.getStats("2panel").foreach((x) => 
                    sendMessage(chan, "2Panel: " + x._1 + ": " + x._2))
                  socPrint.getStats("3panel").foreach((x) => 
                    sendMessage(chan, "3Panel: " + x._1 + ": " + x._2))
                  socPrint.getStats("postcard").foreach((x) => 
                    sendMessage(chan, "PostCard: " + x._1 + ": " + x._2))
                case _ =>
                  sendMessage(chan, "No option: " + arguments.head)
              }
          }
        case _ => null
      }
    }
    // ! commands are for everyone.
    else if (msg.startsWith("!")) {
      val commArg: List[String] = parseCommand(msg)

      commArg(0) match {
        case "!say" =>
          sendMessage(chan, sender+" wants me to say: " +
            commArg(1))
        case _ => null
      }
    }
    if (msg.toLowerCase().startsWith("sgir")) {
      if (isAdminHost(host)) {
        sendMessage(chan, sender + ": Anything you want!")
        sendMessage(chan, sender + ": You're the MAN!")
      }
      else {
        sendMessage(chan, sender+": what u say?")
        sendMessage(chan, sender+": i keel u")
      }
    }
  }

  // Action thrown whenever anyone is kicked in
  // any channel the bot exists.
  override def onKick(chan: String, kicker: String,
            kickerLogin: String, kickerHost: String,
            kickedNick: String, reason: String): Unit = {
    if (kickedNick.startsWith("digicyc")) {
      kick(chan, kicker, "Don't Kick the MAN!")
    }
    if (kickedNick.startsWith("SGir")) {
      joinChannel(chan)
      sendMessage(chan, kicker+": Don't be an ass.")
      kick(chan, kicker, "BOOOM! HS!")
    }
  }

  // Check if the current users host is that of the admins.
  def isAdminHost(hostName: String): Boolean = {
   hostName.startsWith(adminHost)
  }

  override def onJoin(channel: String, joiner: String, login: String,
                       hostname: String)
  {
    config.getList("opsList").foreach{
      isOps =>
      if (hostname == isOps) {
        op(channel, joiner)
      }
    }
  }

  // Parse out the message sent for any possible commands.
  def parseCommand(msg: String): List[String] = {
    val command = msg.split(" ").head.toLowerCase
    val argument = msg.replace(command+" ", "")

    List(command, argument)
  }
}
