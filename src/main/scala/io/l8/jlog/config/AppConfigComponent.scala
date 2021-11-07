package io.l8.jlog.config

import pureconfig.ConfigSource

trait AppConfigComponent {
  val appConfigService: AppConfigService

  trait AppConfigService {
    def load(): Either[String, AppConfig]
  }
}
