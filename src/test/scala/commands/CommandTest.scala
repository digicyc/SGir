package codeoptimus.sgir.test.commands

/**
 * 
 * Created with IntelliJ IDEA.
 * User: Aaron Allred
 */
import org.specs2.mutable._
import commands.Command

class CommandTest extends Specification {

  "Sending a Command" should {
    "give back command" in {
      val (cmd, args) = Command.parseCommand("mycommand is this")
      cmd mustEqual "mycommand"
    }
  }

  "Sending a Command with Arguments" should {
    "give back a list of arguments" in {
      val (cmd, args) = Command.parseArguments("mycommand is this")
      args mustEqual List("is", "this")
    }
  }
}
