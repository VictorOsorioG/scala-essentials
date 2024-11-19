package com.globant.udemy.course.scala_essentials
package lectures.pattern_matching

import scala.util.Random

object PatternMatching extends App {
  println("Like a switch on steroids, state machine")
  val random = new Random
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "one"
    case 2 => "double"
    case 3 => "third"
    case _ => "something"
  }
  println(x)
  println(description)
  println()

  println("Decompose values")
  println("Like a case lass")

  case class Person(name: String, age: Int)

  val bob = Person("Bob", 20)
  val greeting = bob match {
    case Person(n, a) if a < 21 => s"Hi $n a underage"
    case Person(n, a) => s"Hi $n with $a years"
    case _ => "Who"
  }
  println(greeting)
  println("CASES ARE MATCH IN ORDER")
  println("If not default throw MatchError")
  println("The expression is a unified type of all types in all cases")
  println("Works well with case classes come with a extractor pattern")
  println()

  println("Sealed hierarchies -> ensure all childs have a case")

  sealed class Animal

  case class Dog(breed: String) extends Animal

  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Yes")
  animal match {
    case Dog(someBreed) => println(someBreed)
  }

  trait Expr

  case class Number(n: Int) extends Expr

  case class Sum(e1: Expr, e2: Expr) extends Expr

  case class Prod(e1: Expr, e2: Expr) extends Expr

  val expression = Prod(Sum(Number(2), Number(1)), Number(3))

  def show(e: Expr): String = e match {
    case Number(n) => s"$n"
    case Sum(e1, e2) => s"${show(e1)} + ${show(e2)}"
    case Prod(e1, e2) => {
      def maybeParentheses(exp: Expr) = exp match {
        case Prod(_, _) => show(exp)
        case Number(_) => show(exp)
        case _ => s"( ${show(exp)} )"
      }
      s"${maybeParentheses(e1)} * ${maybeParentheses(e2)}"
    }
    case _ => ""
  }

  println(show(expression))
}
