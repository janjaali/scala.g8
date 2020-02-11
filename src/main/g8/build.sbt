name := "$project_name$"

organization := "$organization$"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.13.1"

licenses := Seq("MIT License" -> url("https://opensource.org/licenses/MIT"))

assemblyOutputPath in assembly := file("target/$project_name$.jar")

libraryDependencies ++= Seq(
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",
  "ch.qos.logback" % "logback-classic" % "1.2.3",

  "org.scalatest" %% "scalatest" % "3.0.8" % Test
)
