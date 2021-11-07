package io.l8.jlog.server

trait HttpServiceComponent {

  val httpService: HttpService

  trait HttpService {
    def start(): Unit
  }
}
