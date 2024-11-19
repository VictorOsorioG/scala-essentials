package com.globant.udemy.course.scala_essentials
package lectures.oop

object CaseClasses extends App{

  println("Case class - > class parameters are fields, " +
    "sensible toString (println(instance) = println(instance.toString)), " +
    "equal and hashCode implemented OOTB(out of the box), " +
    "copy method that can change values, " +
    "have companion object, " +
    "serialized useful when dealing with distributed systems (Akka framework -> sends serializable messages through the network), " +
    "have extractor patterns can be used in patter matching," +
    "can be a case object and have the same except for the companion cause the are their own companion")
  case class Person(name: String, age: Int)

  val jim = new Person("Jim", 23)
  println(jim.name)
  println(jim)
  val jim2 = new Person("Jim", 23)
  println(jim == jim2)
  val jim3 = jim.copy(age = 25)
  println(jim3)
  val thePerson = Person
  val mary = Person("Mary", 24)
  case object UK {
    def name: String = "The UK"
  }

}
