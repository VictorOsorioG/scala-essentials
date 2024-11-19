package com.globant.udemy.course.scala_essentials
package lectures.oop

object Generics extends App {
  println("[A] -> Generic type")
  class MyList[A] {

  }
  class MyMap[Key, Value]

  trait behavior[A]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  println("Generic methods")
  object MyList {
    def empty[A]: MyList[A] = ???
  }
  val emptyList = MyList.empty[Int]

  println("Variance problem")
  class Animal
  class Cat extends Animal
  class Dog extends Animal
  println("List[Cat] extends List[Animal] ?")
  println("Yes -> COVARIANCE")
  class CovariantList[+A] {
    def add[B >: A](element: B): MyList[B] = ???
  }
  println("[+A] covariant")
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  println("animalList.add(new Dog) will pollute, will create a list of Animals")
  println("No -> INVARIANCE, can't substitute one for another, use only [A]")
  class InvariantList[A]
  println("val invariantList: InvariantList[Animal] = new InvariantList[Cat] won't compile")
  println("Hell no -> CONTRAVARIANCE [-A]")
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]
  class Trainer[-A]
  val trainer: ContravariantList[Cat] = new ContravariantList[Animal]
  println("This way is more intuitive, if is needed a trainer for cats but has a trainer for animal is better because can train other animals")
  println()

  println("Bounded types [A <: SuperClass] -> Any type a Subtype of the SuperClass")
  println("If use >: tells that only accepts an A superType of the SuperClas")
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)
}
