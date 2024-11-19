package com.globant.udemy.course.scala_essentials
package lectures.functional

object TuplesAndMaps extends App{

  println("Tuples -> finite ordered lists, at most 22, syntax sugar only using ()")
  val aTuple = new Tuple2(2, "hello")
  println(aTuple._1)
  println(aTuple.copy(_2 = "Bye"))
  println(aTuple.swap)
  println()

  println("Maps -> key - value, syntax sugar = key->value or (key, value)")
  val aMap: Map[String, Int] = Map()
  val phoneBook = Map(("Jim", 555), ("Daniel" -> 643))
  println(aMap)
  println(phoneBook)
  println(phoneBook.contains("Jim"))
  println(phoneBook("Jim"))
  println("If a value does not exist will throw an error, to solve this with default value can be use")

  val newPairing = "Mary" -> 4567
  val newPhoneBook = phoneBook + newPairing

  println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2))
  println(phoneBook.view.filterKeys(_.startsWith("J")).toMap)
  println(phoneBook.view.mapValues("+57-"+ _).toMap)
  println(phoneBook.toList)
  println(List(("Daniel", 555)).toMap)
  val names = List("Bob", "Jim", "James")
  println(names.groupBy(name => name.charAt(0)))
  println("Needs to be careful mapping keys because of the overlap")
  println("The + will replace the old paring")
  println()

  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> Set())
  def friend(network: Map[String, Set[String]], person: String, friend: String): Map[String, Set  [String]] = {
    val friendsPerson = network(person)
    val friendsFriend = network(friend)
    network + (person -> (friendsPerson + friend)) + (friend -> (friendsFriend + person))
  }
  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] = {
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))
    }
    val unfriended = removeAux(network(person), network)
    unfriended - person
    /*
    network.removed(person)
    network.map(pair => pair._1 -> (if (pair._2.contains(person)) pair._2 - person else pair._2)) - person

     */
  }

  def unfriend(network: Map[String, Set[String]], person: String, friend: String): Map[String, Set  [String]] = {
    val friendsPerson = network(person)
    val friendsFriend = network(friend)
    network + (person -> (friendsPerson - friend)) + (friend -> (friendsFriend - person))
  }

  def nFriends(network: Map[String, Set[String]], person: String): Int = {
    if (!network.contains(person)) 0 else network(person).size
  }

  def mostFriends(network: Map[String, Set[String]]): String =
    network.maxBy(pair => pair._2.size)._1

  def nPeopleWithNoFriends(network: Map[String, Set[String]]): Int =
    //network.view.filterKeys(network(_).isEmpty).size
    network.count(_._2.isEmpty)

  def socialConnection(network: Map[String, Set[String]], personA: String, personB: String): Boolean = {
    def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean = {
      if (discoveredPeople.isEmpty) false
      else {
        val person = discoveredPeople.head
        if (person == target) true
        else if (consideredPeople.contains(person)) bfs(target, consideredPeople, discoveredPeople.tail)
        else bfs(target, consideredPeople + person, discoveredPeople.tail ++ network(person))
      }
    }
    bfs(personB, Set(), network(personA) + personA)
  }

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(add(empty, "Bob"),"Mary"), "John")
  val networkFriends = friend(friend(network, "Bob", "Mary"), "Bob", "John")
  println(network)
  println(networkFriends)
  println(unfriend(network, "Bob", "Mary"))
  println(remove(network, "Bob"))
  println(nFriends(networkFriends, "Bob"))
  mostFriends(networkFriends)
  nPeopleWithNoFriends(networkFriends)
  println(socialConnection(networkFriends, "Mary", "John"))
}
