package com.globant.udemy.course.scala_essentials
package lectures.basics

object Expressions extends App {
  println()
  val sum: Int = 1 + 2
  println("Expression is a computable statement with a value an type" + sum)
  println("The operations are the usual + - * / & | ^ << >>")
  println(">>> is specific to scala right shift with zero extension")
  var aVariable = 2
  aVariable += 3
  aVariable -= 3
  aVariable /= 2
  println()

  println("Instructions something to do != Expressions")
  println("Everything in Scala is an Expression")
  println()

  println("IF expression")
  val aCondition = true
  val aConditionValue = if (aCondition) 5 else 3
  println(aConditionValue)
  println()

  println("While (Also a Side Effect) NEVER ITERATE THIS WAY, IMPERATIVE CODE = CHANGE PROGRAM STATE")
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }
  println()

  val aWeirdValue = (aVariable = 3)
  println("Unit is the void in Scala, means return anything meaningful, looks like this: " + aWeirdValue)
  println()

  println("Side effects: println, while, reassigning | Expressions returning Unit | Imperative programming")
  println()

  val aCodeBlock = {
    val y = 1
    val z = y + 2
    if (z > 2) "hello" else "goodbye"
  }
  println("The value of a block is the value of its last expression: " + aCodeBlock)
  println("Everything declare inside the code block stays visible within the code block")
  println()

  println("")
  println("Hello String is a value of type String and println Hello is an expression side effect so its Unit")
  val someValue =  {
    2 < 3
  }
  println("SomeValue is of type Boolean " + someValue)
  val someOtherValue = {
    if (someValue) 239 else 983
    42
  }
  println("SomeOtherValue is of type Int and his value is 42 " + someOtherValue)

}
