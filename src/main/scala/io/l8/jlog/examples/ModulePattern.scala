package io.l8.jlog.examples

object ModulePattern extends App {

  trait DataSourceComponent {
    val source: DataSource
    trait DataSource {
      def getData: List[Int]
    }
  }

  trait HttpRequestComponent {
    val http: HttpRequest
    trait HttpRequest {
      def get(url: String): String
    }
  }

  trait LogHttpRequestComponent extends HttpRequestComponent {

    val http: HttpRequest = new LogHttpRequest {}

    trait LogHttpRequest extends HttpRequest {
      override def get(url: String): String = {
        println(s"send request to ${url}")
        List(1, 2, 3, 4, 5, 6).mkString(",")
      }
    }
  }

  trait HttpDataSourceComponent extends DataSourceComponent {
    self: HttpRequestComponent =>

    val source: DataSource = new HttpDataSource {}

    trait HttpDataSource extends DataSource {
      override def getData: List[Int] =
        http.get("http://example.com/data").split(",").map(_.toInt).toList
    }
  }

  trait DataStoreComponent {
    val store: DataStore

    trait DataStore {
      def save(data: List[Int]): Unit
    }
  }

  trait DatabaseComponent {
    val database: Database
    trait Database {
      def runSql(sql: String): Unit
    }
  }

  trait LogDatabaseComponent extends DatabaseComponent {
    val database: Database = new LogDatabase {}
    trait LogDatabase extends Database {
      override def runSql(sql: String): Unit = println(s"run sql ${sql}")
    }
  }

  trait DatabaseStoreComponent extends DataStoreComponent {
    self: DatabaseComponent =>

    val store: DataStore = new DatabaseStore {}

    trait DatabaseStore extends DataStore {
      override def save(data: List[Int]): Unit =
        database.runSql(s"insert into data_table values(${data.mkString(",")})")

    }
  }

  trait DataEncoderComponent {
    val encoder: DataEncoder

    trait DataEncoder {
      def encode(data: List[Int]): List[Int]
    }
  }

  trait PlusOneEncoderComponent extends DataEncoderComponent {
    val encoder: DataEncoder = new PlusOneEncoder {}
    trait PlusOneEncoder extends DataEncoder {
      def encode(data: List[Int]): List[Int] = {
        println(s"encoding ${data}")
        data.map(_ + 1)
      }
    }
  }

  class DataJob {
    self: DataSourceComponent with DataStoreComponent with DataEncoderComponent =>

    def run: Unit = {
      val data        = source.getData
      val encodedData = encoder.encode(data)
      store.save(encodedData)
    }
  }

  object Main {
    def main(): Unit =  {
      val program = new DataJob
        with LogHttpRequestComponent
        with DatabaseStoreComponent
        with HttpDataSourceComponent
        with PlusOneEncoderComponent
        with LogDatabaseComponent

      program.run
    }
  }

  Main.main()

}
