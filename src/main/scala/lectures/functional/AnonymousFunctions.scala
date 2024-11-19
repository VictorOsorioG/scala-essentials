package com.globant.udemy.course.scala_essentials
package lectures.functional

object AnonymousFunctions extends App{

  println("Anonymous function -> LAMBDA (Lambda calculus) -> Instantiates a Function object a VALUE")
  println("We can define the type and the compiler will infer the value")
  val doubler: Int => Int = x => x*2
  println("Or can specify the correct types")
  val double2 = (x: Int) => x*2
  println("When multiple parameters the () are mandatory")
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b
  println("No parameter is just ()")
  val just: () => Int = () => 3
  println(just)
  println(just())
  println("We always need to use () to call the function, if we dont use the () we are just using the function reference")
  val strToInt = {
    (str: String) => str.toInt
  }
  println("{} can also be used with lambdas")
  val niceIncrement: Int => Int = _ + 1
  println("_ + 1 is the equivalent to x => x + 1 -> useful with HOF")
  val niceAdder: (Int,Int) => Int = _ + _
  println("This can only be used if we specify the type")
}
