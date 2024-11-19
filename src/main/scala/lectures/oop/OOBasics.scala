package com.globant.udemy.course.scala_essentials
package lectures.oop

object OOBasics extends App {
  println()
  val person = new Person
  println(person)
  val personWithConstructor = new PersonWithConstructorParameters("Victor", 23)
  println("This is a class with a constructor with parameters")
  println("Class parameters are NOT FIELDS")
  val personWithConstructorParameterAndField = new PersonWithConstructorParameterAndField("Victor", 23)
  println("Now we have a parameter that is also a field" + personWithConstructorParameterAndField.age)
  println("Body in a class defines the implementation of a class, can have val or var, functions, expression, and more")
  val personBody = new PersonWithBody("Victor", 23)
  println("Now this person has a field call x defined in the body " + personBody.x)
  println()

  val fullPerson = new FullPerson("Victor", 23)
  println("This is overloading" + fullPerson.greet("Juan") + "or" + fullPerson.greet())
  println("With def this can overload constructor " + new FullPerson("victor"))
  println("A new constructor has to be another constructor, nothing else")
  println("Can be skipped using default value")
}

class Person

class PersonWithConstructorParameters(name:String, age:Int)

class PersonWithConstructorParameterAndField(name:String, val age:Int)

class PersonWithBody(name: String, val age:Int) {
  val x = 2
  println("Instantiation -> the whole block code is evaluated")
}

class FullPerson(val name: String, val age:Int) {
  def greet(name:String): Unit = println(s"${this.name} says Hi $name")
  def greet(): Unit = println(s"Im ${this.name}")
  def this(name: String) = this(name, 0)
  def this(age:Int) = this("NN", age)
  def this() = this(10)
}
