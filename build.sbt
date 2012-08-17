name := "SGir"

version := "0.9.1"

scalaVersion := "2.9.1"

seq(ProguardPlugin.proguardSettings :_*)

proguardOptions += keepMain("antitech.sgir.SGir")

libraryDependencies ++= {
  val liftVersion = "2.4-M4"
  Seq(
    "com.foursquare" %% "rogue" % "1.1.8" intransitive(),
    "net.liftweb" %% "lift-mongodb-record" % liftVersion,
    "net.liftweb" %% "lift-mongodb" % liftVersion,
    "org.specs2" %% "specs2" % "1.9" % "test",
    "com.mongodb.casbah" %% "casbah" % "2.1.5-1",
    "org.skife.com.typesafe.config" % "typesafe-config" % "0.3.0"
  )
}

resolvers += {
  val typesafeRepoUrl = new java.net.URL("http://repo.typesafe.com/typesafe/releases")
  val pattern = Patterns(false,
    "[organisation]/[module]/[sbtversion]/[revision]/[type]s/[module](-[classifier])-[revision].[ext]")
  Resolver.url("Typesafe Repository", typesafeRepoUrl)(pattern)
}

resolvers ++= Seq("snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
                  "releases"  at "http://oss.sonatype.org/content/repositories/releases",
                  "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"
)
