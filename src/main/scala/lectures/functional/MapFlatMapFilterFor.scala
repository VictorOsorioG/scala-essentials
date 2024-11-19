package com.globant.udemy.course.scala_essentials
package lectures.functional

object MapFlatMapFilterFor extends App {

  println("Calling the list apply method")
  val list = List(1, 2, 3)
  println(list)
  println(list.tail)
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))
  println(list.filter(_ % 2 == 0))
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  val list2 = List('a', 'b', 'c', 'd')
  println("FlatMap -> For each element a list is generated")
  println(list.flatMap((x: Int) => list2.map("" + _ + x)))

  println(list.foreach(println))

  println("For comprehension")
  val forCombinations = for {
    n <- list if n % 2 == 0
    c <- list2
  } yield ("" + n + c)
  println(forCombinations)
  println("This can work only if use a specific signature for the map, flatmap and filter")

  println("Syntax overload")
  println(list.map { x =>
    x * 2
  })

  println()
  val just3 = Just(3)
  println(just3)
  println(just3.map(_ * 2))
  println(just3.flatMap(x => Just(x % 2 == 0)))
  println(just3.filter(_ % 2 == 0))

  println("Scala offers mutable and immutable collections")
  println("mutable -> can be updated in place / Traversable <- iterable <- set (HashSet, LinkedHashSet), seq (<- indexed (StringBuilder), buffer(Array, List), linear(LinkedList, Mutable)), map (HashMap, Multimap)")
  println("immutable -> never change / Traversable <- iterable <- set (HashSet, SortedSet), seq (<- indexed (Vector, String, Range), linear (List, Stream, Stack, Queue)), map(HashMap, SortedMap)")
  println("By default immutable is used")
}

abstract class Maybe[+T] {
  def map[A](f: T => A): Maybe[A]

  def flatMap[A](f: T => Maybe[A]): Maybe[A]

  def filter(predicate: T => Boolean): Maybe[T]
}

case object MaybeNot extends Maybe[Nothing] {

  override def map[A](f: Nothing => A): Maybe[A] = MaybeNot

  override def flatMap[A](f: Nothing => Maybe[A]): Maybe[A] = MaybeNot

  override def filter(predicate: Nothing => Boolean): Maybe[Nothing] = MaybeNot
}

case class Just[+T](value: T) extends Maybe[T] {

  override def map[A](f: T => A): Maybe[A] = Just(f(value))

  override def flatMap[A](f: T => Maybe[A]): Maybe[A] = f(value)

  override def filter(predicate: T => Boolean): Maybe[T] = if (predicate(value)) this else MaybeNot
}
