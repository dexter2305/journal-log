package io.l8.jlog.web

import org.scalatra.ScalatraServlet
import io.l8.jlog.service.RecordService
import io.l8.jlog.domain.Record
import org.slf4j.Logger

class PagesController(service: RecordService) extends ScalatraServlet {

  

  get("/landing") {
    views.html.landing(service.size())
  }

  post("/addRecord") {
    service.add(Record(0, "Sample"))
    redirect(URL.LANDING_PAGE_URL)
  }

  post("/search") {
    params.foreach(p => println(p))
    service.findByContains(params("searchString"))

  }

}
