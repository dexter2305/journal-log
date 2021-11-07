package io.l8.jlog.app

import io.l8.jlog.server.JettyHttpServiceComponent
import io.l8.jlog.config.PureConfigComponent


object Main {

  def main(args: Array[String]) = {

    val live = new JournalLoggerApp with JettyHttpServiceComponent with PureConfigComponent
    live.run()
  }
}
