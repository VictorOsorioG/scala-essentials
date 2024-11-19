package com.globant.udemy.course.scala_essentials
package lectures.basics

object CbNvsCbV extends App {

  def calledByValue(x: Long): Unit = {
    println("by value " + x)
    println("by value " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("by name " + x)
    println("by name " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  println()

  println("By value get computed before the method and that value is used in the entire function")
  println("By name the expression is pass literally and its evaluated everytime")

  println()

  def infinite(): Int = 1 + infinite()

  def printFirst(x: Int, y: => Int) = println(x)

  printFirst(34, infinite())
  println("If uses printFirst(infinite(), 1) will cause stack overflow")

}
