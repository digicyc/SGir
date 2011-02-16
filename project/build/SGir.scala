import sbt._

class SGirProject(info: ProjectInfo) extends DefaultProject(info) with IdeaProject {
  lazy val hi = task { println("SGIR!"); None }
  val casbah = "com.mongodb.casbah" %% "casbah" % "2.0.2"
}
