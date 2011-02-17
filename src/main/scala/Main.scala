package org.antitech.sgir

object Main {
    def main(args: Array[String]): Unit = {
      val config = Config.config
      val sGir = new SGir()
      sGir.connect(config.getString("ircServer").get)
      config.getList("channels").foreach{chan => sGir.joinChannel(chan)}
    }
}
