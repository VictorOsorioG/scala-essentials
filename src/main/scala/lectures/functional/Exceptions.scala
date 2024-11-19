package com.globant.udemy.course.scala_essentials
package lectures.functional

import scala.util.{Failure, Random, Success, Try}

object Exceptions extends App {

  println("Try -> wrapper for a computation that might fail")
  println(" - Failure -> wrap a failed computation")
  println(" - Success -> wrap succeeded computation")
  val aSuccess = Success(3)
  val aFailute = Failure(new RuntimeException("FAIL"))
  println(aSuccess)
  println(aFailute)

  def unsafe(): String = throw new RuntimeException("FAIL")

  def safe(): String = "Safe"

  val potentialFailure = Try(unsafe())
  println(potentialFailure)
  val safeValue = Try(safe())
  println(safeValue)

  val syntaxSuggarFailure = Try {
    unsafe()
    safe()
  }
  println(potentialFailure.isSuccess)

  def backup(): String = "Backup"

  val fallbackTry = Try(unsafe()).orElse(Try(backup()))
  println(fallbackTry)

  def betterUnsafe(): Try[String] = Failure(new RuntimeException("FAIL"))

  def betterBackup(): Try[String] = Success("Backup")

  def betterFallback() = betterUnsafe() orElse betterBackup()

  println(aSuccess.map(_ * 2))
  println(aSuccess.flatMap(x => Success(x * 10)))
  println(aSuccess.filter(_ > 10))
  println()

  val hostname = "localhost"
  val port = "8080"
  def renderHTML(page: String) = println(page)

  class Connection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime())
      if (random.nextBoolean()) "HTML" else throw new RuntimeException("Connection interrupted")
    }

    def getSafe(url: String): Try[String] = Try(get(url))
  }

  object HttpService {
    val random = new Random(System.nanoTime())
    def getConnection(host: String, port: String): Connection = {
      if (random.nextBoolean()) new Connection else throw new RuntimeException("Port took")
    }
    def getSafeConnection(host: String, port: String): Try[Connection] = Try(getConnection(host, port))
  }

  val connection = Try(HttpService.getConnection(hostname, port))
  println(connection.map(_.get("URL")))

  for {
    service <- HttpService.getSafeConnection(hostname, port)
    connection <- service.getSafe("URL")
  } yield renderHTML(connection)

}
