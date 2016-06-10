name := "kha root project"

scalaVersion in ThisBuild := "2.11.8"

lazy val root = project.in(file(".")).
  aggregate(khaJS, khaJVM).
  settings(
    publish := {},
    publishLocal := {}
  )

lazy val kha = crossProject.in(file(".")).
  settings(
    name := "korea-heritage-api",
    version := "0.1-SNAPSHOT",
    libraryDependencies ++= Seq(
      "fr.hmil" %%% "roshttp" % "1.0.0",
      "org.scalatest" %%% "scalatest" % "3.0.0-RC1" % "test"
    )
  ).
  jvmSettings(
    libraryDependencies ++= Seq(
      "org.scala-lang.modules" %% "scala-xml" % "1.0.5"
    )
  ).
  jsSettings(
    libraryDependencies ++= Seq(
      "be.doeraene" %%% "scalajs-jquery" % "0.9.0"
    )
  )

lazy val khaJVM = kha.jvm
lazy val khaJS = kha.js
