package io.l8.jlog.web

import org.scalatra.ScalatraServlet

class IndexPageController extends ScalatraServlet {

  get("/") {
    redirect(URL.LANDING_PAGE_URL)
  }

  get("""/index\.[html|htm]""".r) {
    redirect(URL.LANDING_PAGE_URL)
  }

}
