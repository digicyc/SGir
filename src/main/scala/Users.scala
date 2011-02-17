/**
 * User: aaron
 * Date: 2/15/11
 * Time: 4:55 PM
 *
 * Manages users through a mongodb database.
 */

import com.mongodb.casbah.Imports._

class Users {
  private val mongoColl = MongoConnection("hazmat.cc")("sgir")("users")


}