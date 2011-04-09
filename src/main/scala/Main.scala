package org.antitech.sgir

object Main {
    def main(args: Array[String]): Unit = {
      val sGir = new SGir()
      sGir.connect(Config.config("ircServer"))
      Config.config.getList("channels").foreach(sGir.joinChannel(_))
    }
}
