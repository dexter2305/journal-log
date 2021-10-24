package io.l8.jlog

import org.scalatra.test.scalatest._

class PingServletTests extends ScalatraFunSuite {

  addServlet(classOf[PingServlet], "/*")

  test("GET / on PingServlet should return status 200") {
    get("/") {
      status should equal (200)
    }
  }

}
