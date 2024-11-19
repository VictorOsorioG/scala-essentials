package com.globant.udemy.course.scala_essentials
package lectures.basics

object StringOps extends App{
  val str: String = "Lorem Ipsum is simply dummy text of the printing and typesetting industry."
  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Lorem"))
  println(str.replace(' ', '-'))
  println(str.toLowerCase())
  println(str.toUpperCase())
  println(str.length)

  val aNumberString = "45"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z')
  println(str.reverse)
  println(str.take(2))

  println()
  println("String interpolators")
  println("s -> s: interpolated ")
  val name = "Victor"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old and I will be turning ${age + 1} next year"
  println(greeting)
  println("f -> f: interpolated format string, $name: expand value and name value, %format: format can be s(string) 2.2f(float number 2 total characters, 2 decimal)")
  val speed = 1.2F
  val myth = f"$name%s can eat $speed%2.2f per minute"
  println(myth)
  println("raw -> will print literally")
  println(raw"This is a \n new line")
  val newLine = "This is a \n new line"
  println(raw"$newLine")
}
