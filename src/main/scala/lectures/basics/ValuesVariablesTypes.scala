package com.globant.udemy.course.scala_essentials
package lectures.basics

object ValuesVariablesTypes extends App {
  println()
  println("The structure is: val/var name: Type")
  println()

  val value: Int = 30
  println("Vals are immutable " + value)
  val valueNoType = 27
  println("The compiler can infer types " + valueNoType)
  val aString: String = "Hello";
  val anotherString = "Hi"
  println("Semicolons can be use, but are no necessary unless use multiple expressions on the same line "
    + aString + " " + anotherString)
  val aBoolean: Boolean = true
  val aChar: Char = 'a'
  val aInt: Int = value
  val aShort: Short = 4613
  val aLong: Long = 1L
  val aFloat: Float = 2.0F
  val aDouble: Double = 2.0
  println()

  var aVariable: Int = 4
  println("Variable can be reassigned " + aVariable)
  aVariable = 5
  println("This is a side effect aVariable is now " + aVariable)
  println()

  println("Prefer vals over vars")
}
