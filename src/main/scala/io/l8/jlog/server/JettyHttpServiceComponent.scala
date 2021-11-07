package io.l8.jlog.server

import io.l8.jlog.config.AppConfigServiceComponent
import org.eclipse.jetty.webapp.WebAppContext
import org.scalatra.servlet.ScalatraListener
import org.eclipse.jetty.server.Server
import io.l8.jlog.config.Port

trait JettyHttpServiceComponent extends HttpServiceComponent {
  self: AppConfigServiceComponent =>

  override val httpService: HttpService = new JettyHttpService
  
  class JettyHttpService extends HttpService {

    override def start(): Unit = {
      appConfigService.load() match {
        case Left(errorMessage) => scribe.error(s"Error while starting Http service. Cause: $errorMessage")
        case Right(appConfig)   =>
          val server  = new Server(appConfig.port.value())
          val context = new WebAppContext
          context.setContextPath("/")
          context.setResourceBase("src/main/scala/webapp/")
          context.addEventListener(new ScalatraListener)

          server.setHandler(context)
          server.start
      }
    }
  }
}
