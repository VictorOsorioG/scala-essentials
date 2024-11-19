package com.globant.udemy.course.scala_essentials
package lectures.oop

import scala.runtime.Nothing$

abstract class MyList[+A] {

  /*
  Linked list of integer
  head
  tail
  isEmpty
  add => new List
  toString
   */
  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyList[B]

  def printElements: String

  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: A => B): MyList[B]

  def filter(predicate: A => Boolean): MyList[A]

  def flatMap[B](transformer: A => MyList[B]): MyList[B]

  def ++[B >: A](list: MyList[B]): MyList[B]

  def foreach(f: A => Unit)

  def sort(compare: (A, A) => Int): MyList[A]

  def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C]

  def fold[B](start: B)(operator: (B,A) => B): B
}

case object Empty extends MyList[Nothing] {

  override def head: Nothing = throw new NoSuchElementException()

  override def tail: MyList[Nothing] = throw new NoSuchElementException()

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](element: B): MyList[B] = new Cons[B](element, Empty)

  override def printElements: String = ""

  override def map[B](transformer: Nothing => B): MyList[B] = Empty

  override def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  override def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  override def foreach(f: Nothing => Unit): Unit = ()

  override def sort(compare: (Nothing, Nothing) => Int): MyList[Nothing] = Empty

  override def zipWith[B, C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] =
    if (!list.isEmpty) throw new RuntimeException("List do not have the same length")
    else Empty

  override def fold[B](start: B)(operator: (B, Nothing) => B): B = start
}

case class Cons[+A](h: A, t: MyList[A] = Empty) extends MyList[A] {

  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](element: B): MyList[B] = new Cons[B](element, this)

  override def printElements: String = if (t.isEmpty) s"$h" else s"$h ${t.printElements}"

  override def map[B](transformer: A => B): MyList[B] =
    new Cons[B](transformer(h), this.t.map(transformer))

  override def filter(predicate: A => Boolean): MyList[A] =
    if (predicate(h)) new Cons[A](h, this.t.filter(predicate)) else this.t.filter(predicate)

  override def flatMap[B](transformer: A => MyList[B]): MyList[B] = {
    transformer(h) ++ t.flatMap(transformer)
  }

  override def ++[B >: A](list: MyList[B]): MyList[B] =
    new Cons(h, t ++ list)

  override def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  override def sort(compare: (A, A) => Int): MyList[A] = {
    def insert(value: A, sortedList: MyList[A]): MyList[A] = {
      if (sortedList.isEmpty) new Cons(value, Empty)
      else if (compare(value, sortedList.head) <= 0) new Cons(value, sortedList)
      else new Cons(sortedList.head, insert(value, sortedList.tail))
    }

    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }

  override def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] = {
    if (list.isEmpty) throw new RuntimeException("List do not have the same length")
    new Cons[C](zip(h, list.head), t.zipWith(list.tail, zip))
  }

  override def fold[B](start: B)(operator: (B, A) => B): B = {
    t.fold(operator(start, h))(operator)
  }
}

/*
trait MyPredicate[-T] {
  def test(t: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(a: A): B
}

object EvenPredicate extends MyPredicate[Int] {
  override def test(t: Int): Boolean = t % 2 == 0
}

object StringToIntTransformer extends MyTransformer[String, Int] {
  override def transform(a: String): Int = a.toInt
}
 */


object ListTest extends App {
  val list: MyList[Int] = new Cons(1)
  println(list.head)
  val list2: MyList[Int] = new Cons(1, new Cons(2, new Cons(3)))
  println(list2.head)
  println(list2.add(4).head)
  println(list.toString)
  println(list2.toString)
  println("toString, equals, hashCode are methods that are present in any ref class")
  println()

  println("Nothing is a proper substitute for any type")
  val list3: MyList[String] = new Cons[String]("Hello")
  println(list3.toString)
  println()

  val even = 4
  val nonEven = 13
  val one = "1"
  val two = "2"
  /*
  println(EvenPredicate.test(even))
  println(EvenPredicate.test(nonEven))
  println(StringToIntTransformer.transform(one))
  println(StringToIntTransformer.transform(two))
   */
  println(list2.map((a: Int) => a * 2).toString)
  println(list2.filter((a: Int) => a % 2 == 0).toString)
  println((list ++ list2).toString)
  println(list2.flatMap(
    (a: Int) => new Cons[Int](a, new Cons[Int](a + 1)): MyList[Int]
  ).toString)
  println(
    """
      |[1,2].flatMap(n => [n,n+1])
      |[1,2] ++ [2].flatMap(n => [n, n+1])
      |[1,2] ++ [2,3] ++ Empty..flatMap(n => [n, n+1])
      |[1,2,2,3]
      |""".stripMargin)
  println(
    """
      |[1,2] ++ [3,4,5]
      |new Cons(1, [2] ++ [3,4,5])
      |new Cons(1, new Cons(2, Empty ++ [3,4,5]))
      |new Cons(1, new Cons(2, [3,4,5]))
      |""".stripMargin)
  list2.foreach(println)
  val list4: MyList[Int] = new Cons(4, new Cons(5, new Cons(6)))
  println(list2.zipWith(list4, (x: Int, y: Int) => x * y).toString)
  println(list2.zipWith[Int, String](list4, _ + "-" + _))
  println(list2.sort((x, y) => y - x))
  println(list2.fold[Int](1)(_ + _))
  println(list2.fold[String]("Nb:")(_ + _))
  println(
    for {
      x <- list2
      h <- list3
    } yield "" + x + h
  )
}
