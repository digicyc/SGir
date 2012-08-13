package codeoptimus.sgir.mouthhole

/**
 * User: aaron
 * Date: 4/13/11
 * Time: 7:16 PM
 *
 * Random quotes from Gir as reponses to certain words.
 */

object Speak {
  private val girQuotes: Map[String, String] = Map(
    "show" -> "I love this show!",
    "pig1" -> "Tell me a story about giant pigs!",
    "pig2" -> "Let's go to my room, PIG!",
    "pig3" -> "I loveded you piggy, I loveded you",
    "doomsong1" -> "I'm gonna sing the Doom song now.",
    "doomsong2" -> "Doom doom doom doom doom doom doom",
    "doomsong3" -> "Doom doom doom doomy doomy doom doomy doom",
    "mission" -> "Blend in with indigenous life, analyze their weaknesses, prepare the planet for the coming madness.... YAY!",
    "biscuit" -> "Lets make biscuits! LETS MAKE BISCUITS!",
    "monkey1" -> "Aww, but I wanna watch the Scary Monkey Show!",
    "monkey2" -> "I'm dancin' like ah monkey!",
    "head" -> "Your head smells like a puppy!",
    "dog" -> "MEOW!",
    "hug" -> "Somebody needs a hug!",
    "explode" -> "Awwwww... I wanted to explode.",
    "executive" -> "I am exec man, come from the execs. The execs has sent me.",
    "tacos1" -> "But I need tacos! I need them or I will explode",
    "tacos2" -> "Taco. Taco. Taco.",
    "tacos3" -> "I love the little tacos. I love them good.",
    "squirrel1" -> "Me and the squirrel are friends!",
    "squirrel2" -> "I saw a squirrel, he was doin' like this.........",
    "run" -> "I'm runnin'-I'm runnin', I'm naked, And I'm Runnin'!",
    "leave" -> "No wait-come back. I need shtuff.",
    "esplode" -> "Awww.. I wanted to esplode.."
  )

  private var lastRand = -1

  private def randomize(seed: Int): Int = {
    val rand = new util.Random
    var randVal = -1
    do {
      randVal = rand.nextInt(seed)
    }
    while (randVal == lastRand)
    lastRand = randVal
    randVal
  }

  def getQuote(msg: String): String = {
    val umsg = msg.toLowerCase

    if (umsg contains "pig") {
      randomize(3) match {
        case 0 => girQuotes("pig1")
        case 1 => girQuotes("pig2")
        case 2 => girQuotes("pig3")
        case _ => girQuotes("pig3")
      }
    }
    else if ((umsg contains "biscuit") || (umsg contains "waffle")) {
      girQuotes("biscuit")
    }
    else if (umsg contains "run") {
      girQuotes("run")
    }
    else if (umsg contains "show") {
      girQuotes("show")
    }
    else if (umsg contains "dog") {
      girQuotes("dog")
    }
    else if (umsg contains "leave") {
      girQuotes("leave")
    }
    else if (umsg contains "doom") {
      randomize(3) match {
        case 0 => girQuotes("doomsong1")
        case 1 => girQuotes("doomsong2")
        case 2 => girQuotes("doomsong3")
      }
    }
    else if (umsg contains "mission") {
      girQuotes("mission")
    }
    else if (umsg contains "monkey") {
      randomize(2) match {
        case 0 => girQuotes("monkey1")
        case 1 => girQuotes("monkey2")
      }
    }
    else if (umsg contains "head") {
      girQuotes("head")
    }
    else if (umsg contains "explode") {
      girQuotes("explode")
    }
    else if (umsg contains "squirrel") {
      randomize(2) match {
        case 0 => girQuotes("squirrel1")
        case 1 => girQuotes("squirrel2")
      }
    }
    else if (umsg contains "taco") {
      randomize(3) match {
        case 0 => girQuotes("tacos1")
        case 1 => girQuotes("tacos2")
        case 2 => girQuotes("tacos3")
      }
    }
    else if (umsg contains "exec") {
      girQuotes("executive")
    }
    else {
      ""
    }
  }
}
