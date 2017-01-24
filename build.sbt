scalaVersion := "2.11.8"
//crossScalaVersions := Seq("2.11.8", "2.12.1")


name := "cite"
organization := "edu.holycross.shot"
version := "3.1.1"

//licenses += ("GPL-3.0", url("https://opensource.org/licenses/gpl-license"))


// dependencies for scalatest
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" %  "test"
libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "1.0.6"

// dependencies for specs2
resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
libraryDependencies += "org.specs2" %% "specs2-core" % "3.8.7" % "test"


// can't get right resolver patterns for ammonite 0.8
// series yet....
/*
libraryDependencies += "com.lihaoyi" % "ammonite" % "0.8.1" cross CrossVersion.full

libraryDependencies += "com.lihaoyi" %% "ammonite-ops" % "0.8.1"



//scalacOptions in Test ++= Seq("-Yrangepos")

//initialCommands in (Test, console) := """ammonite.Main().run()"""
*/

publishTo := Some("Sonatype Snapshots Nexus" at "http://beta.hpcc.uh.edu/nexus/content/repositories/releases/")

credentials += Credentials(Path.userHome / "nexusauth.txt" )
