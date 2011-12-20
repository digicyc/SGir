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
    "org.specs2" %% "specs2" % "1.6.1"
  )
}

resolvers ++= Seq("snapshots" at "http://scala-tools.org/repo-snapshots",
                  "releases"  at "http://scala-tools.org/repo-releases",
                  "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"
)
