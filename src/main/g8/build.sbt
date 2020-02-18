ThisBuild / name := "$project_name;format="lower,hyphen"$"

ThisBuild / organization := "$organization$"

ThisBuild / version := "1.0.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.1"

ThisBuild / licenses := Seq("MIT License" -> url("https://opensource.org/licenses/MIT"))

lazy val app = (project in file("app"))
  .settings(
    name := "app",

    mainClass in Compile := Some("$organization$.$project_name;format="space,Camel"$"),

    libraryDependencies ++= Seq(
      // logging
      "ch.qos.logback" % "logback-classic" % "1.2.3",
      "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",

      // tests
      "org.scalatest" %% "scalatest" % "3.0.8" % Test
    ),

    packageName in Docker := "$organization$/$project_name;format="lower,hyphen"$"
  )
  .enablePlugins(JavaAppPackaging)
