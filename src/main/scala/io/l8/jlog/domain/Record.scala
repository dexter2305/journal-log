package io.l8.jlog.domain

import java.time.Instant

case class Record(id: Int = 0, log: String, t: Instant = Instant.now())
