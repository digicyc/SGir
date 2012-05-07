name := "SGir"

version := "0.9.1"

scalaVersion := "2.9.1"

seq(ProguardPlugin.proguardSettings :_*)

proguardOptions += keepMain("antitech.sgir.SGir")

libraryDependencies ++= {
  val liftVersion = "2.4-M4"
  Seq(
    "com.foursquare" %% "rogue" % "1.0.27" intransitive(),
    "net.liftweb" %% "lift-mongodb-record" % liftVersion,
    "net.liftweb" %% "lift-mongodb" % liftVersion,
    "org.specs2" %% "specs2" % "1.9" % "test",
    "com.mongodb.casbah" %% "casbah" % "2.1.5-1"
  )
}

resolvers ++= Seq("snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
                  "releases"  at "http://oss.sonatype.org/content/repositories/releases",
                  "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"
)
