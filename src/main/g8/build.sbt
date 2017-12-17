name := "$project_name$"

organization := "$organization$"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.12.4"

licenses := Seq("MIT License" -> url("https://opensource.org/licenses/MIT"))

homepage := Some(url("$project_url$"))

assemblyOutputPath in assembly := file("target/$project_name$.jar")

val dependencies = Seq(
  "com.typesafe.scala-logging" %% "scala-logging" % "3.7.2",
  "ch.qos.logback" % "logback-classic" % "1.2.3"
)

val testDependencies = Seq(
  "com.typesafe.akka" %% "akka-http-testkit" % "10.0.9" % Test,
  "org.scalatest" %% "scalatest" % "3.0.1" % Test
)

libraryDependencies ++= dependencies
libraryDependencies ++= testDependencies
