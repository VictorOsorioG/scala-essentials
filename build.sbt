ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.15"

lazy val root = (project in file("."))
  .settings(
    name := "scala-essentials",
    idePackagePrefix := Some("com.globant.udemy.course.scala_essentials")
  )
