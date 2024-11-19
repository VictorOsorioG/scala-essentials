package com.globant.udemy.course.scala_essentials
package lectures.functional

object HOFAndCurries extends App {

  println("HOF -> Takes function as parameter or return a function")
  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null
  println("f(f(f(3)))")

  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))

  val plusOne = (x: Int) => x + 1
  println(nTimes(plusOne, 10, 1))

  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n - 1)(f(x))

  println(nTimesBetter(plusOne, 10))
  println(nTimesBetter(plusOne, 10)(1))
  println()

  println("Curried functions")
  val supperAdder = (x: Int) => (y: Int) => x + y
  val add3 = supperAdder(3)
  println(add3(10))
  println(supperAdder(3)(10))
  println("May help to define helper functions that can be use latter")
  println("Functions with multiple parameter lists that act liked curried functions")
  println("Needs to define the type")

  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")
  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))
  println()

  def toCurry(f: (Int, Int) => Int): (Int => Int => Int) =
    x => y => f(x, y)

  def fromCurry(f: Int => Int => Int): (Int, Int) => Int =
    (x, y) => f(x)(y)

  def compose[A,B,T](f: A => B, g: T => A): T => B =
    x => f(g(x))

  def andThen[A,B,C](f: A => B, g: B => C): A => C =
    x => g(f(x))

  def supperAdder2: (Int => Int => Int) = toCurry((_ + _))
  def add4 = supperAdder2(4)
  println(add4(17))

  val add2 = (x: Int) => x + 2
  val times3 = (x: Int) => x * 3
  val composed = compose(add2, times3)
  val ordered = andThen(add2, times3)
  println(composed(4))
  println(ordered(4))

  println("Function X has the implementation for the compose and andThen")
}
