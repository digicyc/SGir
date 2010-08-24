package org.antitech.sgir

import org.jibble.pircbot.PircBot

class SGir extends PircBot {
    private val name: String = "SGir"
    
    setName("SGir")
    setLogin("SGir")
    
    override def onMessage(chan: String, sender: String,
                  login: String, host: String, 
                  msg: String): Unit = {
        if (msg.startsWith("=")) {
            val command = msg.toLowerCase().replaceFirst("=", "")

            if (command.startsWith("join"))
                joinChannel(command.substring(5))
            if (command.startsWith("say"))
                sendMessage(chan, msg.substring(5))
            if (command.startsWith("exit"))
                System.exit(1)
        }
    }
}
