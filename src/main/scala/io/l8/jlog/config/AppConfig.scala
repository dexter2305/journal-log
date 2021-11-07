package io.l8.jlog.config

case class Port(port: Int) extends AnyVal
case class AppConfig(port: Port)