name             := "NetUtil"
version          := "1.0.2"
organization     := "de.sciss"
description      := "A Java library for sending and receiving messages using the OpenSoundControl (OSC) protocol"
homepage         := Some(url(s"https://github.com/Sciss/${name.value}"))
licenses         := Seq("LGPL v2.1+" -> url("http://www.gnu.org/licenses/lgpl-2.1.txt"))
scalaVersion     := "2.11.11"  // this is just a Java only project; use Scala 2.11 so we can compile under Java 6
crossPaths       := false      // this is just a Java only project
autoScalaLibrary := false      // this is just a Java only project

// we are using Scala for testing only
libraryDependencies += "org.scala-lang" % "scala-library" % scalaVersion.value % "test"

// ---- publishing ----

publishMavenStyle := true

publishTo :=
  Some(if (isSnapshot.value)
    "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
  else
    "Sonatype Releases"  at "https://oss.sonatype.org/service/local/staging/deploy/maven2"
  )

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := { val n = name.value
<scm>
  <url>git@github.com:Sciss/{n}.git</url>
  <connection>scm:git:git@github.com:Sciss/{n}.git</connection>
</scm>
<developers>
  <developer>
    <id>sciss</id>
    <name>Hanns Holger Rutz</name>
    <url>http://www.sciss.de</url>
  </developer>
</developers>
}
