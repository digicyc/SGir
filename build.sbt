import AssemblyKeys._

name := "SGir"

assemblySettings

mainClass in assembly := Some("codeoptimus.sgir.SGir")

jarName in assembly := "SGir.jar"

version := "0.9.1"

scalaVersion := "2.9.1"

libraryDependencies ++= {
  val liftVersion = "2.4-M4"
  Seq(
    "com.foursquare" %% "rogue" % "1.1.8" intransitive(),
    "net.liftweb" %% "lift-mongodb-record" % liftVersion,
    "net.liftweb" %% "lift-mongodb" % liftVersion,
    "org.specs2" %% "specs2" % "1.9" % "test",
    "com.mongodb.casbah" %% "casbah" % "2.1.5-1",
    "com.codahale" %% "logula" % "2.1.3",
    "com.typesafe.akka" % "akka-actor" % "2.0.3"
  )
}

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers ++= Seq("snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
                  "releases"  at "http://oss.sonatype.org/content/repositories/releases",
                  "Java.net Maven2 Repository" at "http://download.java.net/maven/2/",
                  "repo.codahale.com" at "http://repo.codahale.com"
)
