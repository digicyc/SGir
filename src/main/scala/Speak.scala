package org.antitech.sgir

/**
 * User: aaron
 * Date: 4/13/11
 * Time: 7:16 PM
 *
 * Random quotes from Gir as reponses to certain words.
 */

object Speak {
  private val girQuotes: Map[String, String] = Map(
    "show"      -> "I love this show!",
    "pig1"      -> "Tell me a story about giant pigs!",
    "pig2"      -> "Let's go to my room, PIG!",
    "pig3"      -> "I loveded you piggy, I loveded you",
    "doomsong1" -> "I'm gonna sing the Doom song now.",
    "doomsong2" -> "Doom doom doom doom doom doom doom",
    "doomsong3" -> "Doom doom doom doomy doomy doom doomy doom",
    "mission"   -> "Blend in with indigenous life, analyze their weaknesses, prepare the planet for the coming madness.... YAY!",
    "biscuit"   -> "Lets make biscuits! LETS MAKE BISCUITS!",
    "monkey1"   -> "Aww, but I wanna watch the Scary Monkey Show!",
    "monkey2"   -> "I'm dancin' like ah monkey!",
    "head"      -> "Your head smells like a puppy!",
    "dog"       -> "MEOW!",
    "hug"       -> "Somebody needs a hug!",
    "explode"   -> "Awwwww... I wantedf to explode.",
    "executive" -> "I am exec man, come from the execs. The execs has sent me.",
    "tacos1"    -> "But I need tacos! I need them or I will explode",
    "tacos2"    -> "Taco. Taco. Taco.",
    "tacos3"    -> "I love the little tacos. I love them good.",
    "squirrel1" -> "Me and the squirrel are friends!",
    "squirrel2" -> "I saw a squirrel, he was doin' like this.........",
    "run"       -> "I'm runnin'-I'm runnin', I'm naked, And I'm Runnin'!",
    "leave"     -> "No wait-come back. I need shtuff.",
    "eslode"    -> "Awww.. I wanted to esplode.."
  )

  private def trackTime() {

  }

  def getQuote(msg: String): String = {
    val words = msg.split(" ")
    val response =
      girQuotes filterKeys { myKey =>
        myKey contains word;
        getRandomQuote()
      }
  }
}