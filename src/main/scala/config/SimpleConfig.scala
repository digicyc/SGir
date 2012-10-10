package codeoptimus.sgir.config

import com.typesafe.config._

object SimpleConfig  {
  val config = ConfigFactory.load("sgir")
  config.checkValid(ConfigFactory.defaultReference(), "sgir")

  def getConfig = config

  def printSetting(path: String) {
    println("The setting '" + path + "' is: " + config.getString(path))
  }

}
