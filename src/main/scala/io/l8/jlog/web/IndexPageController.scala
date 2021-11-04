package io.l8.jlog.web

import org.scalatra.ScalatraServlet

class IndexPageController extends ScalatraServlet {

  get("/") {
    redirect(Routes.LANDING_ROUTE)
  }

  get("""/index\.[html|htm]""".r) {
    redirect(Routes.LANDING_ROUTE)
  }

}
