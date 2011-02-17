/**
 * User: aaron
 * Date: 2/14/11
 * Time: 11:14 AM
 *
 */
package org.antitech.sgir

import net.lag.configgy.Configgy
import net.lag.logging.Logger

object Config  {
  Configgy.configure("conf/sgir.conf")

  def logger = Logger.get

  def config = Configgy.config

  def reloadConfig = {
    Configgy.configure("conf/sgir.conf")
    config = Configgy.config
  }
}