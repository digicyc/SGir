package codeoptimus.sgir

import net.lag.configgy.Configgy
import net.lag.logging.Logger

import simplelib._

object SimpleConfig(config: Config)  {
  config.checkValid(ConfigFactory.defaultReference(), "sgir")
  
  def this() {
    this(ConfigFactory.load("sgir"))
  }

  def printSetting(path: String) {
    println("The setting '" + path + "' is: " + config.getString(path)
  }

  def getPath = config.getString(path)

}
