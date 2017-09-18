package net.habashi.cicero

import akka.actor.{ActorSystem, Props}
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.HttpResponse
import akka.http.scaladsl.model.StatusCodes._
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.{ExceptionHandler, Route}
import akka.pattern.ask
import akka.stream.ActorMaterializer
import akka.util.Timeout
import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.ExecutionContextExecutor
import scala.io.StdIn

object Server extends App with LazyLogging {

  implicit private val system = ActorSystem("cicero")

  implicit private val executionContext: ExecutionContextExecutor = system.dispatcher

  implicit private val materializer = ActorMaterializer()

  private val (host, port) = ("0.0.0.0", 8080)

  private val exceptionHandler = ExceptionHandler {
    case ex: Exception =>
      logger.error(s"catch exception in route expetionHandler: \${ex.getMessage}")
      complete(HttpResponse(InternalServerError, entity = "Something went wrong!"))
  }

  val route: Route =
    handleExceptions(exceptionHandler) {
      get {
        complete("$project_name$")
      }
    }

  private val bindingFuture = Http().bindAndHandle(route, host, port)

  logger.info(s"Server started on \$host:\$port. Press RETURN to stop ...")

  StdIn.readLine()

  bindingFuture
    .map(_.unbind())
    .onComplete(_ => system.terminate())

}
