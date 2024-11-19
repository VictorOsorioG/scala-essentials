package com.globant.udemy.course.scala_essentials
package lectures.basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Long = {
    if (n <= 0) 1
    else {
      println("Computing factorial of " + n + " Need first factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)
      result
    }
  }

  def anotherFactorial(n: Int): BigInt = {
    def factHelper(x: Int, accumulator: BigInt): BigInt = if (x <= 1) accumulator else factHelper(x - 1, x * accumulator)

    factHelper(n, 1)
  }

  // factorial(5000) will fail
  // anotherFactorial(5000)
  println("The factorial with a large number will fail because the operation requires memory on the stack for the computing of the result" +
    "with the other function there's no need to save intermediate results to use later")
  println("TAIL RECURSION")
  println("Use recursive call as the LAST expression")
  println("The trick is to use accumulators to store intermediate rather than call the function recursively")
  println("Can use the @tailrec to tell the compiler it should be a  tail, if not, will throw an error")
  println()

  println("WHEN NEED LOOPS USE TAIL RECURSION")
  println()

  def concat(s: String, times: Int): String = {
    def concatHelper(accumulator: String, t: Int): String = if (t <= 1) accumulator else concatHelper(accumulator + s, t - 1)

    concatHelper(s, times)
  }

  println(concat("Hola", 3))

  def fibonacci(n: Int): Int = {
    @tailrec
    def fibonacciHelper(x: Int, n_1: Int, n_2: Int): Int = if (x <= 2) n_1 else fibonacciHelper(x - 1, n_1 + n_2, n_1)

    fibonacciHelper(n, 1, 1)
  }

  println(fibonacci(8))

  def isPrime(n: Int): Boolean = {
    def stillPrime(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else stillPrime(t - 1, n % t != 0 && isStillPrime)

    stillPrime(n / 2, true)
  }

  println(isPrime(37))


}
