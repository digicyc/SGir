package codeoptimus.sgir.braincase

import net.liftweb.mongodb.record._
import net.liftweb.mongodb.record.field._
import net.liftweb.record._
import net.liftweb.record.field._

class IRCUser private() extends MongoRecord[IRCUser] with MongoId[IRCUser] {
  def meta = IRCUser

  object name extends StringField(this, 80)
  object hostname extends StringField(this, 150)
  object channels extends MongoListField[IRCUser, String](this)
  object karma extends IntField(this, 0)
}

object IRCUser extends IRCUser with MongoMetaRecord[IRCUser] {
  override def collectionName = "ircusers"
}
