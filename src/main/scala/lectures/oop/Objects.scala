package com.globant.udemy.course.scala_essentials
package lectures.oop

object Objects {
  def main(args: Array[String]): Unit = {
    println("Class level functionality -> Things that don't relay on class instance")
    println("SCALA DOES NOT HAVE CLASS LEVEL FUNCTIONALITY (static)")
    println("The most close to a static is an object")
    object Person {
      val N_EYES = 2

      def from(mother: Person, father: Person): Person = new Person("Bob")

      def apply(mother: Person, father: Person): Person = new Person("Bob")
    }
    println(Person.N_EYES)
    println("OBJECTS DO NOT RECEIVE PARAMETERS")
    println()

    println("OBJECTS AS SINGLETON")
    println("Companions -> Create an object for the class level functionality and a class for instance level functionality")
    class Person(val name: String) {

    }
    println("The from or apply methods are like a factory method, builds a person given his some parameters")
    val mary = new Person("Mary")
    val john = new Person("John")
    val bob = Person(mary, john)
    println()

    println("Scala applications is a scala object with a main method like java, the statics is referred to the object")
  }
}
