package com.globant.udemy.course.scala_essentials
package lectures.oop

import java.time.LocalDate

object OOPBasicExercises extends App {
  val writer = new Writer("Edgar", "Poe", 1809)
  println(writer.getFullName)
  val novel = new Novel("The raven", 1843, writer)
  println(novel.getAuthorAge)
  println(novel.isWrittenBy(writer))
  val copyNovel = novel.copy(2000)
  println(copyNovel)
  val counter = new Counter()
  counter.incrementCounter.incrementCounter.incrementCounter.print
  counter.incrementCounter.incrementCounter.incrementCounter.incrementCounter(5).print
}

class Writer(firstname: String, surname: String, dateOfBirth: Int) {
  def getFullName: String = firstname + " " + surname

  def getDateOfBirth: Int = dateOfBirth
}

class Novel(name: String, yearOfRelease: Int, author: Writer) {
  def getAuthorAge: Int = LocalDate.now().getYear - author.getDateOfBirth

  def isWrittenBy(author: Writer): Boolean = this.author.equals(author)

  def copy(newYearOfRelease: Int): Novel = new Novel(this.name, newYearOfRelease, this.author)
}

class Counter(value: Int = 0) {
  def getCurrentCounter: Int = this.value

  def incrementCounter = new Counter(value + 1)

  def decrementCounter = new Counter(value - 1)

  def incrementCounter(n: Int) = new Counter(value + n)

  def decrementCounter(n: Int) = new Counter(value - n)

  def print = println(value)
}
