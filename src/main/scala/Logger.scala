package codeoptimus.sgir

import com.codahale.logula.Logging
import org.apache.log4j.Level

object LogSetup {
  def initLogger = {
    Logging.configure { log =>
      log.registerWithJMX = true

      log.level = Level.INFO
      log.loggers("codeoptimus.sgir") = Level.OFF

      log.console.enabled = true
      log.console.threshold = Level.INFO

      log.file.enabled = true
      log.file.filename = "~/log/sgir/sgir.log"
      log.file.maxSize = 10 * 1024
      log.file.retainedFiles = 5

      log.syslog.enabled = true
      log.syslog.host = "syslog-001.internal.optim.us"
      log.syslog.facility = "local3"
    }
  }
}
