package io.l8.jlog.app

import io.l8.jlog.server.HttpServiceComponent
import io.l8.jlog.config.AppConfigComponent

class JournalLoggerApp {
  self: HttpServiceComponent with AppConfigComponent =>

  def run(): Unit = httpService.start()
}