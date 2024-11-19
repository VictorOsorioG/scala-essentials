package com.globant.udemy.course.scala_essentials
package lectures.functional

import java.util.Random

object Options extends App {

  println("Option -> Wrapper for a value that might be present or not")
  println("Some -> concrete value, None -> absent value")
  println("To never do a null check")

  val aOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None
  println(aOption)
  println(noOption)

  def unsafe(): String = null

  val result = Option(unsafe())
  println(result)

  def backup(): String = "Backup"

  val chainedResult = Option(unsafe())
    .orElse(Option(backup()))

  println(chainedResult)

  def betterUnsafe(): Option[String] = None

  def betterBackup(): Option[String] = Some("Valid")

  val betterChainedResult = betterUnsafe() orElse betterBackup()
  println(betterChainedResult)
  println(aOption.isEmpty)
  println("The get breaks the point for a option")
  println(aOption.get)
  println(aOption.map(_*2))
  println(aOption.filter(_ > 10))
  println(aOption.flatMap(x => Option(x*10)))
  println()

  val config: Map[String, String] = Map(
    "host" -> "111.11.11.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected"
  }
  object Connection {
    val random = new Random(System.nanoTime())
    def apply(host: String, port: String): Option[Connection] = {
      if (random.nextBoolean()) Some(new Connection) else None
    }
  }

  val host = config.get("host")
  val port = config.get("port")
  val connection = host.flatMap(h => port.flatMap(p => Connection(h, p)))
  val connectionStatus = connection.map(c => c.connect)
  println(connectionStatus)
  connectionStatus.foreach(print)
  /*
  if (host.isDefined && port.isDefined) {
    val connection = Connection(host.get, port.get)
    if (connection.isDefined) println(connection.get.connect)
  }
  else println("Can't")
   */
  for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect.foreach(print)
}
