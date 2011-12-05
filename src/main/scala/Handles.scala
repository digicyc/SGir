package antitech.sgir

/**
 * Created by IntelliJ IDEA.
 * User: aaron
 * Date: 12/3/11
 * Time: 2:33 AM
 * To change this template use File | Settings | File Templates.
 */

object Handles {
  case class Message(
    chan: String, sender: String,
    login: String,  host: String,
    message: String
  )
}