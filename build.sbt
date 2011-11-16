name := "SGir"

version := "0.9.1"

scalaVersion := "2.9.0-1"

libraryDependencies ++= {
  val liftVersion = "2.4-M3"
  Seq(
    "com.foursquare" %% "rogue" % "1.0.22" intransitive(),
    "net.liftweb" %% "lift-mongodb-record" % liftVersion,
    "net.liftweb" %% "lift-mongodb" % liftVersion,
    "org.specs2" %% "specs2" % "1.6.1"
  )
}

resolvers ++= Seq("snapshots" at "http://scala-tools.org/repo-snapshots",
                  "releases"  at "http://scala-tools.org/repo-releases",
                  "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"
)
