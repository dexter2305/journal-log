package io.l8.jlog

import org.scalatra._
import org.scalatra.json.JacksonJsonSupport
import org.json4s.Formats
import org.json4s.DefaultFormats
import io.l8.jlog.service.RecordService

class PingServlet(recordService: RecordService) extends ScalatraServlet with JacksonJsonSupport {

  override implicit protected def jsonFormats: Formats = DefaultFormats

  before() {
    contentType = "application/json"
  }

  get("/") {
    s"OK: Size is ${recordService.size()}"
  }

}
