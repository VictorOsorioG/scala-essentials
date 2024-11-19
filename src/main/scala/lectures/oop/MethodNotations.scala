package com.globant.udemy.course.scala_essentials
package lectures.oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie:String) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"No $name"
    def isAlive: Boolean = true
    def apply(): String =s"Im $name"
  }

  val mary = new Person("Mary", "Up")
  println("Infix notation or Operator notation (Syntactic sugar/Natural language)")
  println("Only works with only one parameter")
  println(mary.likes("Up"))
  println(mary likes "Up")

  println("The method works as operator between mary and tom")
  val tom = new Person("Tom", "Venom")
  println(mary hangOutWith tom)
  println("Some characters are not reserved in Scala, like + - and more")
  println()

  println("Mathematical operators act like methods")
  println(1 + 2)
  println(1.+(2))
  println("ALL OPERATOR ARE METHODS")
  println()

  println("Prefix notation")
  println("unary_ only works with - + and other i don't know to to type")
  val x = -1
  val xSame = 1.unary_-
  println(!mary)
  println(mary.unary_!)
  println()

  println("Postfix notation")
  println(mary.isAlive)
  println(mary isAlive)
  println()

  println("Apply")
  println(mary.apply())
  println(mary())
}
