import java.net.URL

import scala.util.{Failure, Success, Try}


val url = Try(new URL("bogus")).orElse(Try(new URL("http://google.com")))

url match {
  case Success(u) => println("yay")
  case Failure(e) => println(s"oops ${e.getMessage}")
}