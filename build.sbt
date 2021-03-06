import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "io.aravindh",
      scalaVersion := "2.12.1",
      version      := "0.1.0-SNAPSHOT",
      name          := "sbuilder"
    )),
    name := "Hello",
    libraryDependencies += scalaTest % Test
  )

libraryDependencies ++= Seq(
  "com.chuusai" % "shapeless_2.12" % "2.3.2",
  "org.scalatest" % "scalatest_2.12" % "3.0.1"
)
