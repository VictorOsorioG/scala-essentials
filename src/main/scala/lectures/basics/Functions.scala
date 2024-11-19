package com.globant.udemy.course.scala_essentials
package lectures.basics

object Functions extends App {

  println()
  println("Function structure: def functionName(parameters with name:type) : return type = implementation or {code block implementation}")

  def aFunction(a: String, b: Int): String = a + " " + b

  def aFunctionWithNoReturnValue(a: String, b: Int) = a + " " + b

  println("aFunction: " + aFunction("This is a", 2))
  println("Calling the function is also an expression")
  println("Compiler can also know the return type of a function")

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())
  println(aParameterlessFunction)
  println()

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("Hello", 3))
  println("When using recursion need to specify the return type to the function")
  println("WHEN NEED LOOPS, USE RECURSION")
  println()

  def aFunctionWithSideEffect(aString: String): Unit = println(aString)

  println("Unit can also be a return type for a function, means only execute side effects")
  aFunctionWithSideEffect("Hello")
  println()

  println("Auxiliary functions")

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n - 1)
  }
  println(aBigFunction(2))
  println()

  def hello(name: String, age: Int): String = "Hi, my name is " + name + " and I am " + age + " years old"

  println(hello("victor", 23))

  def factorial(n: Int): Long = if (n <= 0) 1 else n * factorial(n - 1)

  println(factorial(5))

  def fibonacci(n: Int): Int = if (n <= 2) 1 else fibonacci(n - 1) + fibonacci(n - 2)

  println(fibonacci(8))

  def isPrime(n: Int): Boolean = {
    def module(divisor: Int): Boolean = if (divisor <= 1) true else n % divisor != 0 && module(divisor - 1)

    module(n / 2)
  }

  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37 * 17))
}
