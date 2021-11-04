package io.l8.jlog.app

import org.eclipse.jetty.webapp.WebAppContext
import org.scalatra.servlet.ScalatraListener
import org.eclipse.jetty.server.Server
import io.l8.jlog.web.model.MRecord

object Main {

  def main(args: Array[String]): Unit = {
    start()
  }

  def testJson(): Unit = {
    import org.json4s._
    import org.json4s.jackson.JsonMethods._
    val data = """
    {
      "text": "logging from rest client"
    }
    """
    val x = parse(data).asInstanceOf[JObject]
    println(x)
    println(s"${x \ "text"}")

    ///
    implicit val formats = DefaultFormats
    val jsValue = parse(data)
    val mrecord: MRecord = jsValue.extract[MRecord]
    println(mrecord)

  }
  def start(): Unit = {
    val context = new WebAppContext
    context.setContextPath("/")
    context.setResourceBase("src/main/scala/webapp")
    context.addEventListener(new ScalatraListener)
    val server  = new Server(8080)
    server.setHandler(context)
    server.start()
  }

}
