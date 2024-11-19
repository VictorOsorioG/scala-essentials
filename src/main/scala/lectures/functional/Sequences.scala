package com.globant.udemy.course.scala_essentials
package lectures.functional

import scala.util.Random

object Sequences extends App{

  println("Sequences -> Seq -> defined order, indexes")
  val aSequence = Seq(1,3,2,4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(5,6,7))
  println(aSequence.sorted)
  println()

  println("Ranges")
  val aRange: Seq[Int] = 1 to 10
  val anotherRange: Seq[Int] = 1 until 10
  aRange.foreach(println)
  anotherRange.foreach(println)
  (1 to 2).foreach(println)
  println()

  println("LinearSeq immutable linked list")
  println("Sealed - has two subtypes -> Nil(empty), ::")
  val aList = List(1,2,3)
  val prepended = 42 +: aList
  val appended = aList :+ 56
  println(prepended)
  println(appended)
  val apples5 = List.fill(5)("apple")
  println(apples5)
  println(aList.mkString("-"))
  println()

  println("Arrays -> native java, predefined length, mutated, indexing, default values")
  val numbers = Array(1,2,3,4)
  val treeElements = Array.ofDim[Int](3)
  println(numbers.foreach(print))
  println(treeElements.foreach(print))
  println("To update Array.update(pos, value) or syntax sugar")
  numbers(2) = 0
  println("Implicit conversion")
  val numbersSeq: Seq[Int] = numbers
  println()

  println("Vectors -> default implementation immutable sequence, effectively constant indexed, O(log32(n)), good performance")
  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)
  val maxRuns = 1000
  val maxCapacity = 100000
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }
    times.sum * 1.0 / maxRuns
  }
  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector
  println(getWriteTime(numbersList))
  println(getWriteTime(numbersVector))

}
