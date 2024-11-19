package com.globant.udemy.course.scala_essentials
package lectures.oop

object Inheritance extends App {

  println("Single class inheritance but multiple traits")

  class Animal {
    def eat = println("nomnom")

    private def privateEat = println("private nomnom")

    protected def protectedEat = println("protected nomnom")

    val creatureType: String = "Wild"
  }

  class Cat extends Animal {
    def crunch = protectedEat
  }

  val cat = new Cat
  cat.eat
  println("Cat is a subclass of Animal and Animal is a superclass of Cat")
  println("Only inherits non private methods")
  println("Private only in the class")
  println("Protected only within class and subclass")
  println("Default or no modifier which is public")
  cat.crunch
  println()

  println("Constructor")

  class Person(name: String, age: Int)

  class Adult(name: String, age: Int, id: String) extends Person(name, age)

  println("JVM rule -> call constructor of superclass before subclass constructor")
  println()

  println("Overriding works for methods and vals")

  class Dog extends Animal {
    override def protectedEat = {
      super.eat
      print("crunch, crunch")
    }

    override val creatureType: String = "domestic"
  }

  val dog = new Dog
  dog.protectedEat
  println(dog.creatureType)
  println("Can also override with parameters like Dog(override val creatureType) and instance Dog(Domestic)")
  println("Type substitution -> polymorphism   Will go to the most overridden version")
  val unknown: Animal = new Dog
  unknown.eat
  println()

  println("Super -> reference a method or field from a superclass")
  println()

  println("Preventing overrides using final on member(can't override), class (can't extend), sealed the class (extend only in the file)")
}
