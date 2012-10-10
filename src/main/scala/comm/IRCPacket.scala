package codeoptimus.sgir.comm

/**
 * 
 * Created with IntelliJ IDEA.
 * User: Aaron Allred
 */
case class IRCPacket(val chan: String, val sender: String,
                val login: String, val host: String,
                val msg: String)
