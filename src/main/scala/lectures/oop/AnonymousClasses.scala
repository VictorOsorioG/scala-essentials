package com.globant.udemy.course.scala_essentials
package lectures.oop

object AnonymousClasses extends App {
  abstract class Animal {
    def eat: Unit
  }
  val funnyAnimal: Animal = new Animal{
    override def eat: Unit = println("jejeje")
  }
  println("Anonymous classes is a class with no name")
  println("THE ARGUMENTS NEEDS TO BE PASS EVEN IF IS ANONYMOUS CLASS")
  println("Need to implement all abstract field/methods")
  println("Works for abstract and non-abstract")
  println("The compiler creates the class like this AnonymousClasses$$anon$n")
  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, im $name")
  }
  val jim = new Person("Jim") {
    override def sayHi: Unit = println("Hi, im Jim")
  }

}
