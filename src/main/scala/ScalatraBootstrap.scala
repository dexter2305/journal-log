import io.l8.jlog._
import org.scalatra._
import javax.servlet.ServletContext
import io.l8.jlog.service.InMemoryRecordServiceImpl
import io.l8.jlog.web.PagesController
import io.l8.jlog.web.IndexPageController
import io.l8.jlog.web.LoginController

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext): Unit = {

    context.setInitParameter("org.scalatra.environment", "development")

    val recordService = new InMemoryRecordServiceImpl

    context.mount(new PingServlet(recordService), "/api/ping/*")
    context.mount(new LoginController, "/web/login.route/*")
    context.mount(new PagesController(recordService), "/web/*")
    context.mount(new IndexPageController, "/*")
  }
}
