ThisBuild / name := "$project_name$"

ThisBuild / organization := "$organization$"

ThisBuild / version := "1.0.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.1"

ThisBuild / licenses := Seq("MIT License" -> url("https://opensource.org/licenses/MIT"))

lazy val app = (project in file("app"))
  .settings(
    name := "app",

    mainClass in Compile := Some("$organization$.$project_name$"),

    libraryDependencies ++= Seq(
      "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",
      "ch.qos.logback" % "logback-classic" % "1.2.3",

      "org.scalatest" %% "scalatest" % "3.0.8" % Test
    )
  )
  .enablePlugins(JavaAppPackaging)
