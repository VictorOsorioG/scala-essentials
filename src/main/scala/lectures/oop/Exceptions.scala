package com.globant.udemy.course.scala_essentials
package lectures.oop

object Exceptions extends App {

  println("Throwing and catching exceptions")
  println("Can be throw using -> throw new Exception")
  println("The exceptions can be assigned")
  //val exception = throw new NullPointerException()
  println("throwable classes extend the Throwable class")
  println("Exception (Something went wrong with the program) and Error (Something went wrong with the system) are the major Throwable subtype")
  println("catch using try catch")

  def getInt(withException: Boolean): Int = if (withException) throw new RuntimeException("No Int") else throw new NullPointerException("No Int")

  val fail = try {
    getInt(true)
  } catch {
    case e: RuntimeException => 10
  } finally {
    println("Finally")
  }
  println("Exceptions are from Java cause of the JVM")
  println(fail)
  println("Finally does not influence the return type, used for side effects only")
  println("Class can be define like in Java")

  class MyException extends Exception

  println()

  object Calculator {
    def add(x: Int, y: Int): Int = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int): Int = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int): Int = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new UnderflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int) = if (y == 0) throw new MathCalculationException else x / y
  }

  class MathCalculationException extends RuntimeException

  class OverflowException extends RuntimeException

  class UnderflowException extends RuntimeException

  println(Calculator.add(2000000000, 1000000000))

  try {
    Array.ofDim(Int.MaxValue)
  } catch {
    case e: OutOfMemoryError => println("Out of memory")
  }

  try {
    def sum(a: Int): Int = a + sum(a)

    sum(1000)
  } catch {
    case e: StackOverflowError => println("Stack over flow")
  }

  try {
    println(Calculator.add(2000000000, 2000000000))
  } catch {
    case e: OverflowException => println("Exceed max value")
  }

  try {
    println(Calculator.subtract(10, 0))
  } catch {
    case e: UnderflowException => println("Exceeds min value")
  }

  try {
    println(Calculator.divide(10, 0))
  } catch {
    case e: MathCalculationException => println("Cant divide 0")
  }
}
