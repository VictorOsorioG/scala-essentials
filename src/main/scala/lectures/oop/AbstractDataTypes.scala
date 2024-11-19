package com.globant.udemy.course.scala_essentials
package lectures.oop

object AbstractDataTypes extends App {
  println("Abstract Data Types -> Fields or methods blank or unimplemented")
  abstract class Animal {
    val creatureType: String
    def eat: Unit
    val nonAbstract: String = "Non abstract"
  }
  println("Abstract class can't be instantiated")

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    override def eat: Unit = println("Crunch")
  }
  println()

  println("Traits -> like interfaces can be inference multiple")
  trait Carnivore {
    def eat(animal: Animal) :Unit
    val nonAbstractInTrait: String = "Non abstract"
  }
  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"
    override def eat: Unit = println("Crunch")
    override def eat(animal: Animal): Unit = println(s"Eats ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)
  println()

  println("Traits vs Abstract -> " +
    "abstract can have abstract and non abstract types the same as traits " +
    "traits do not have constructor parameters, but in scala 3 is now possible " +
    "extend only once, with multiple " +
    "traits behavior, abstract type")
  println()

  println("Any the mother of all types")
  println("Right")
  println("AnyRef mapped to Java Object -> all classes derive from this unless its says")
  println("Null -> No reference")
  println("Left")
  println("AnyVal -> primitive values")
  println("Derives from all is -> Nothing -> can replace everything subtype of everything, not even null or unit")
}
