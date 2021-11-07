package io.l8.jlog.config

import pureconfig.ConfigSource

trait AppConfigServiceComponent {
  val appConfigService: AppConfigService

  trait AppConfigService {
    def load(): Either[String, AppConfig]
  }
}
