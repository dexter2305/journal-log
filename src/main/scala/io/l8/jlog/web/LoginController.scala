package io.l8.jlog.web

import org.scalatra.ScalatraServlet

class LoginController extends ScalatraServlet {
  
  post("/*") {
    val id = params("email")
    val password = params("password")
    scribe.info(s"user:$id && password: $password")
    if (id == "admin@jl.io" && password =="secret") redirect(Routes.LANDING_ROUTE)
    else halt(403)
  }
}