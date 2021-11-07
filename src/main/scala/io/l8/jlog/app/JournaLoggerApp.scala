package io.l8.jlog.app

import io.l8.jlog.server.HttpServiceComponent
import io.l8.jlog.config.AppConfigServiceComponent

class JournalLoggerApp {
  self: HttpServiceComponent with AppConfigServiceComponent =>

  def run(): Unit = httpService.start()
}