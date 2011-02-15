package org.antitech.sgir

//import org.antitech.sgir.SGir

object Main {
    def main(args: Array[String]): Unit = {
        val sGir = new SGir()
        sGir.connect("irc.freenode.net")
        sGir.joinChannel("#botfactory")
    }
}
