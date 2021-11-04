package io.l8.jlog.web.model

import java.time.Instant
import io.l8.jlog.domain.Record

final case class MRecord(text: String) {

  def asDomainModel: Record = Record(id = 0, text, Instant.now())
}