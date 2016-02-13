package petstore.db

import com.typesafe.config.ConfigFactory
import com.typesafe.scalalogging.LazyLogging
import reactivemongo.api.{DB, DefaultDB, MongoConnection, MongoDriver}

import scala.util.{Failure, Success}

/**
  * Singleton that manages the connections to our MongoDB.
  *
  * Currently only allows for use of a single database.
  *
  * Created by terry on 1/20/16.
  *
  */
object MongoContext extends LazyLogging {
  val config = ConfigFactory.load()
  val mongoUri = config.getString("mongo.uri")
  lazy val driver = new MongoDriver

  lazy val db = {
    logger.info(s"ReactiveMongo Starting....mongo.uri: $mongoUri")

    val parsedUri = MongoConnection.parseURI(mongoUri) match {
      case Success(uri) if uri.db.isDefined => uri
      case Success(_) => throw new Exception(s"Missing db name in the mongodb.uri: '$mongoUri'")
      case Failure(e) => throw new Exception(s"Invalid mongodb.uri: '$mongoUri'")
    }

    val connection = driver.connection(parsedUri)

    parsedUri.db.fold[DefaultDB](throw new Exception(s"Cannot resolve database from URI: $mongoUri")) {
      uri =>
        val db = DB(uri, connection)
        logger.info("ReactiveMongo successfully started.")
        db
    }
  }
}