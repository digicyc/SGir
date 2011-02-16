import sbt._

class Plugins(info: ProjectInfo) extends PluginDefinition(info) {
    val extract = "org.scala-tools.sbt" % "installer-plugin" % "0.3.0"
    val sbtIdeaRepo = "sbt-idea-repo" at "http://mpeltonen.github.com/maven/"
    val sbtIdea = "com.github.mpeltonen" % "sbt-idea-plugin" % "0.2.0"
}
