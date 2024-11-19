package com.globant.udemy.course.scala_essentials
package lectures.pattern_matching

import lectures.oop.{Cons, MyList, Empty}

object AllThePatterns extends App {
  println("Constants")
  val x: Any = "Scala"
  val constants = x match {
    case 1 => "Number"
    case "Scala" => "Scala"
    case true => "True"
    case AllThePatterns => "A singleton"
    case _ =>
  }

  println("Match anything - wildcard")
  val matchAnything = x match {
    case _ =>
  }

  println("Variable")
  val matchVariable = x match {
    case something => s"$something"
    case _ =>
  }

  println("Tuples")
  val aTuple = (1, 2)
  val matchATuple = aTuple match {
    case (1, 1) =>
    case (something, 2) => s"$something"
    case _ =>
  }
  println("PM can be NESTED")
  val nestedTuple = (1, (2, 3))
  val matchANestedTuple = nestedTuple match {
    case (_, (2, v)) =>
    case _ =>
  }

  println("case classes -> constructor pattern")
  val aList: MyList[Int] = Cons(1, Cons(2))
  val matchAList = aList match {
    case Empty =>
    case Cons(head, Cons(subhead, subtail)) =>
    case _ =>
  }

  val aStandarList = List(1, 2, 3, 42)
  val matchStandarList = aStandarList match {
    case List(1, _, _, _) => "Extractor"
    case List(1, _*) => "List of arbitrary length"
    case 1 :: List(_) => "Infix pattern"
    case List(1, 2, 3) :+ 42 => "Infix pattern"
    case _ =>
  }

  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] => "Explicit type specifier"
    case _ =>
  }

  println("Name binding")
  val nameBindingMatch = aList match {
    case nonEmptyList@Cons(_, _) => "Name binding -> use the name later the nonEmptyList"
    case Cons(1, rest@Cons(2, _)) => "Name binding -> inside nested patterns"
    case _ =>
  }

  println("Multipatterns")
  val multiPattern = aList match {
    case Empty | Cons(0, _) => "Compound pattern"
    case _ =>
  }

  println("If guards")
  val secondElementSpecial = aList match {
    case Cons(_, Cons(h, _)) if h % 2 == 0 => "if guards"
    case _ =>
  }

  println("JVM trick question")

  val numbers = List(1, 2, 3)
  val numbersMatch = numbers match {
    case strings: List[String] => "List of string"
    case ints: List[Int] => "List of int"
    case _ =>
  }
  println(numbersMatch)
  print("Because of compatible with older java versions JVM erased all generics after type checking, " +
    "so both match look like this List and the first will be use")

  println()

  println("Catches are MATCHES")
  try {

  } catch {
    case _ =>
  }
  println("Generator (<-) are based on pattern matching")
  val evenOnes = for {
    x <- numbers if x %2 == 0
  } yield x

  println("Like in JS")
  println("Multiple value definition based on PM")
  val tuple = (1,2,3)
  val (a,b,c) = tuple

  println("Works with ALL the patterns")

  println("Partial functions")
  val mappedList = numbers.map {
    case v if v%2 == 0 => "Even"
    case _ => "No even"
  }


}
