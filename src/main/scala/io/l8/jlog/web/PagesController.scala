package io.l8.jlog.web

import org.scalatra.ScalatraServlet
import io.l8.jlog.service.RecordService
import org.json4s.DefaultFormats
import org.json4s.Formats
import org.scalatra.json.JacksonJsonSupport
import io.l8.jlog.web.model.MRecord
import io.l8.jlog.domain.Record
import org.json4s._
import org.json4s.jackson.JsonMethods._
import org.scalatra.Ok
class PagesController(service: RecordService) extends ScalatraServlet {

  get("/landing.route") {
    val logCount = service.size()
    val recent5  = service.findLast5Records()
    views.html.landing(logCount, recent5)
  }

  post("/addRecord.route") {
    val payload = request.body
    scribe.info(s"payload '$payload'")
    service.add(Record(0, s"payload: '${payload}'"))
    //println(s"added $recordModel")
    redirect(Routes.LANDING_ROUTE)
  }

}
