package com.globant.udemy.course.scala_essentials
package lectures.basics

object DefaultArgs extends App {
  def trFac(n: Int, acc: Int = 1): Int = if (n <= 1) acc else trFac(n - 1, n * acc)

  val fact10 = trFac(10)

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("Saving picture")

  savePicture(width = 800)
  println("Although we can use default values if we omit the first parameter it will throw an error, " +
    "because it takes the parameters in the order they are defined")
  println("We can pass the argument by name parameters")
}
