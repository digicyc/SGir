package codeoptimus.sgir.model

import net.liftweb.mongodb.record._
import net.liftweb.mongodb.record.field._
import net.liftweb.record._
import net.liftweb.record.field._

class User private() extends MongoRecord[User] with MongoId[User] {
  def meta = User

  object name extends StringField(this, 80)
  object hostname extends StringField(this, 150)
  object channels extends MongoListField[User, String](this)
  object karma extends IntField(this, 0)
}

object User extends User with MongoMetaRecord[User] {
  override def collectionName = "users"
}
