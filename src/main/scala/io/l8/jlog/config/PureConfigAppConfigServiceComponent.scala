package io.l8.jlog.config

trait PureConfigAppConfigServiceComponent extends AppConfigServiceComponent {
  import pureconfig.ConfigSource
  import pureconfig.generic.auto.exportReader

  override val appConfigService: AppConfigService = new PureConfigAppService

  class PureConfigAppService extends AppConfigService {
    override def load(): Either[String, AppConfig] = { 
     ConfigSource.default.load[AppConfig] match {
       case Left(errors) => Left(errors.prettyPrint(2))
       case Right(appConfig) => Right(appConfig)
     }
    }
  }
}
