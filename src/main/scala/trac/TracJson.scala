package trac

/**
 * Get Ticket information from Trac via JSON.
 */

class TracJson {
  private val GetTicket = """.*#(\d+).*""".r

  def parseString(msg: String): Int = msg match {
    case GetTicket(ticketNum) => ticketNum.toInt
    case _ => 0
  }

  def getTicket(ticketId: Int) = {
    
  }
}