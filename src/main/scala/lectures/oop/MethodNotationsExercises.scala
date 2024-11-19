package com.globant.udemy.course.scala_essentials
package lectures.oop

import scala.language.postfixOps

object MethodNotationsExercises extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int) {
    def +(nickname: String) : Person = new Person(this.name + " " + nickname, this.favoriteMovie, this.age)
    def unary_+ : Person = new Person(this.name, this.favoriteMovie, this.age + 1)
    def learns(thing: String) = println(s"Mary learns $thing")
    def learnsScala = learns("Scala")
    def apply() =  println(s"${this.name} likes ${this.favoriteMovie}")
    def apply(times: Int) = println(s"${this.name} watched ${this.favoriteMovie} $times times")
  }

  val mary = new Person("Mary", "Up", 23)
  (mary + "the rockstar").apply()
  println(mary.age)
  println((+mary).age)
  println(mary learnsScala)
}
