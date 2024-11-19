package com.globant.udemy.course.scala_essentials
package lectures.oop

import playground.{Play, Xbox => X}

import java.util.Date
import java.sql.{Date => SqlDae}

object PackagingAndImports extends App{

  println("Everything will be part of package lectures.oop")
  println("Package members are accessible by their simple name")
  val writer = new Writer("Victor", "M", 2024)
  println("If not in the proper package, need to import the package")
  println("Can be access using the fully qualified name -> new playground.Play")
  val play = new Play
  println("Ordered in hierarchy")
  println("Package object -> methods or constants outside everything else / Universal constants / One per package")
  println("Visible throw out the package")
  sayHello
  println(CONSTANT)
  val xbox = new X
  println("{classes} or _ to all")
  println("The import can be recall using =>  Useful when multiple classes with the same name")
  println("If have the same name and dont specify will use the first import")
  println("Default imports are automatically imported " +
    "like java.lang -> String, Object, Exception /" +
    " scala -> Int, Nothing, Function /" +
    " scala.Predef -> pringln, ???")

}
