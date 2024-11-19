package com.globant.udemy.course.scala_essentials
package lectures.oop

object Scala3Enums {

  /*

  enum Permissions {
    case READ, WRITE, EXECUTE, NONE

    def open(): Unit = if (this == READ) println("open") else println("Cant do")
  }

  val somePermissions: Permissions = Permissions.READ

  enum PermissionWithBits(bits: Int) {
    case READ extends PermissionWithBits(4)
    case WRITE extends PermissionWithBits(2)
    case EXECUTE extends PermissionWithBits(1)
    case NONE extends PermissionWithBits(0)
  }

  object PermissionWithBits {
  def fromBits(bits: Int): PermissionWithBits = PermissionWithBits.NONE
  }
   */


  println("Cant be instance, only use the constant, can be extended")
  println("Can have fields an methods")
  println("Can have constructor arguments")
  println("Can have companions")
  println("Can see the ordinal for the enum definitions, index of the vale")
  println("Can see the values")
  println("Can get a value by string that match with the value")

}
