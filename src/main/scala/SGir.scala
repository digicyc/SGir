package codeoptimus.sgir

import braincase.IRCUser
import braincase.UserManagement
import org.jibble.pircbot.PircBot
import org.joda.time.DateTime
import com.foursquare.rogue.Rogue._
import mouthhole.Speak
import com.codahale.logula.Logging


object SGir extends PircBot with Logging {
  private val config = SimpleConfig.getConfig
  private val botName = config.getString("botName")
  private val adminHost = config.getString("adminHost")

  LogSetup.initLogger

  setName(botName)
  setLogin(botName)

  /**
    * Will check everyone in each channel we are in into our system.
    */
  def checkChannelIn = {
    val allUsers =  ""
  }

  // Is called whenever any message is sent.
  override def onMessage(chan: String, sender: String,
                         login: String, host: String,
                         msg: String): Unit = {
    // = Commands are for Admin and Control.
    if (msg.startsWith("=") && isAdminHost(host)) {
      val command = msg.split(" ").head.toLowerCase
      val arguments = msg.split(" ").drop(1).toList

      command match {
        case "=join" =>
          joinChannel(arguments.head)
        case "=say" => sendMessage(chan,
          arguments.reduceLeft[String] {
            (y, z) => y + " " + z
          })
        //case "=reload" => config.reload()
        case "=exit" => System.exit(1)
        case "=reverse" => sendMessage(chan,
          arguments.reduceLeft[String] {
            (y, z) => z + " " + y
          })
        case "=op" =>
          arguments.foreach(op(chan, _))
        case "=deop" =>
          arguments.foreach(deOp(chan, _))

        case _ => None
      }
    }
    // ! commands are for everyone.
    else if (msg.startsWith("!")) {
      val commArg: List[String] = parseCommand(msg)

      commArg(0) match {
        case "!say" =>
          sendMessage(chan, sender + " wants me to say: " +
            commArg(1))
        case _ => None
      }
    }
    if (msg.toLowerCase().startsWith("sgir")) {
      val speak = Speak.getQuote(msg)
      if (speak != "") {
        sendMessage(chan, speak)
      }
      else {
        sendMessage(chan, "[o_O]")
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
      sendMessage(chan, kicker + ": Don't be an ass.")
      kick(chan, kicker, "BOOOM! HS!")
    }
  }

  // Check if the current users host is that of the admins.
  def isAdminHost(hostName: String): Boolean = {
    hostName.startsWith(adminHost)
  }

  override def onJoin(channel: String, joiner: String, login: String, hostname: String) {
    isOps(joiner, hostname, channel)
    checkIn(channel, joiner, login, hostname)
  }

  /**
   * checkin user or add them into DB if not already.
   * We want this to return a braincase.User.
   */
  def checkIn(channel: String, joiner: String, login: String, hostname: String): IRCUser = {
    val user = new UserManagement()
    user.checkInUser(login, hostname, channel)
  }

  def isOps(joiner: String, hostname: String, channel: String) {
    import scala.collection.JavaConversions._

    config.getStringList("opsList").toList.foreach {
      isOps =>
        if (hostname == isOps) {
          op(channel, joiner)
        }
    }
  }

  // Parse out the message sent for any possible commands.
  def parseCommand(msg: String): List[String] = {
    val command = msg.split(" ").head.toLowerCase
    val argument = msg.replace(command + " ", "")

    List(command, argument)
  }

  def main(args: Array[String]): Unit = {
    import scala.collection.JavaConversions._

    log.info("SGir Initiated.")
    connect(config.getString("ircServer"))
    config.getStringList("channels").toList.foreach(joinChannel(_))
  }
}
