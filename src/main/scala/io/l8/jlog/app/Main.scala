package io.l8.jlog.app

import io.l8.jlog.server.JettyHttpServiceComponent
import io.l8.jlog.config.PureConfigAppConfigServiceComponent


object Main {

  def main(args: Array[String]) = {

    val live = new JournalLoggerApp with JettyHttpServiceComponent with PureConfigAppConfigServiceComponent

  }
}
