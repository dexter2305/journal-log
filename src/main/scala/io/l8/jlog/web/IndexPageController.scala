package io.l8.jlog.web

import org.scalatra.ScalatraServlet

class IndexPageController extends ScalatraServlet {

  def indexPage() = views.html.index()

  get("/") {
    indexPage()
  }

  get("""/index\.[html|htm]""".r) {
    indexPage()
  }

}
