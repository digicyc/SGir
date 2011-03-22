import sbt._

class SGirProject(info: ProjectInfo) extends DefaultProject(info) with IdeaProject {
  lazy val hi = task { println("SGIR!"); None }
  val casbah = "com.mongodb.casbah" %% "casbah" % "2.0.2"
  val scalatest = "org.scalatest" % "scalatest" % "1.3"
}
