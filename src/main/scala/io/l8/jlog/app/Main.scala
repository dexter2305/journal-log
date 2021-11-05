package io.l8.jlog.app

import org.eclipse.jetty.webapp.WebAppContext
import org.scalatra.servlet.ScalatraListener
import org.eclipse.jetty.server.Server

object Main {

  def main(args: Array[String]): Unit = {
    start()
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
