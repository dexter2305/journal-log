package io.l8.jlog.service

import io.l8.jlog.domain.Record
import scala.collection.mutable.Map

trait RecordService {

  def findAll(): Option[Seq[Record]]

  def add(newRecord: Record): Int

  def findById(id: Int): Option[Record]

  def findByContains(searchString: String): Option[Seq[Record]]

  def findLast5Records(): Seq[Record]

  def size(): Int
}

class InMemoryRecordServiceImpl() extends RecordService {

  val store: Map[Int, Record] = Map.empty[Int, Record]

  override def findAll(): Option[Seq[Record]] = {
    Option(store.values.toList.sortBy(_.t))
  }

  override def add(newRecord: Record): Int = {
    if (newRecord.log.isEmpty()) store.size
    else store += (store.size -> newRecord.copy(id = store.size))
    store.size
  }

  override def findById(id: Int): Option[Record] = store.get(id)

  override def size(): Int = store.size

  override def findByContains(searchString: String): Option[Seq[Record]] = {
    Option(store.filter { case (_, r) =>
      r.log.contains(searchString)
    }.map { case (_, r) =>
      r
    }.toList)
  }

  override def findLast5Records(): Seq[Record] = store.values.toList.sortBy(_.t).reverse.take(5)
}
