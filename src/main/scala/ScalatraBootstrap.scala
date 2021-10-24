import io.l8.jlog._
import org.scalatra._
import javax.servlet.ServletContext
import io.l8.jlog.service.InMemoryRecordServiceImpl
import io.l8.jlog.web.PagesController
import io.l8.jlog.web.IndexPageController

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext): Unit = {
    
    context.setInitParameter("org.scalatra.environment", "development")
    
    val recordService = new InMemoryRecordServiceImpl


    context.mount(new PingServlet(recordService), "/api/ping/*")
    context.mount(new PagesController(recordService), "/web/pages/*")
    context.mount(new IndexPageController, "/*")
  }
}