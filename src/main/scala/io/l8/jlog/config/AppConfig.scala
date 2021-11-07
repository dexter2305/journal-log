package io.l8.jlog.config

case class Port(port: Int) extends AnyVal {
  def value(): Int = port
}
case class AppConfig(port: Port)
