package com.globant.udemy.course.scala_essentials
package lectures.functional

object AFunction extends App{

  println("Functions as first class elements")
  println("The problem is that in OOP to use a function we are using an object and its how the JVM works")
  println("The trick in scala is to use apply to call like a function, so the instance can be avoid")
  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }
  println(doubler(2))
  println("Function types = Function*[A, B] * a number")
  println("Up to 22 parameters")
  val stringToInt = new Function1[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }
  println(stringToInt("3"))
  val adder: (Int, Int) => Int = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }
  println(adder(2,4))
  println("(parameters) => Result")
  val subtract = (v1: Int, v2: Int) => v1 - v2
  println(subtract(1,4))
  println("ALL SCALA FUNCTIONS ARE OBJECTS DERIVED FROM FUNCTION 1..22")
  val concat = (v1: String, v2: String) => v1.concat(v2)
  val supperAdder: (Int => (Int => Int)) = new Function1[Int, Function1[Int, Int]] {
    override def apply(v1: Int): Int => Int = new Function[Int, Int] {
      override def apply(v2: Int): Int = v1 + v2
    }
  }
  val adder3 = supperAdder(3)
  println(adder3(4))
  println(supperAdder(3)(4))
  println("Higher order functions -> functions as parameters or return other functions")
  println("Curried function -> can be called with multiple parameter list" +
    "function that receive a parameter and return another function which receives parameters")
  val supperAdderAF: Int => Int => Int = (v1: Int) => (v2: Int) => v1 + v2
}

trait Action[A, B] {
  def execute(element: A): B = ???
}

trait MyFunction[A, B] {
  def apply(element: A): A
}
