package antitech.sgir.model

/**
 *  Represents an IRC user.
 */

import net.liftweb.mongodb._
import record.field._
import net.liftweb.record.field._
import record.{MongoMetaRecord, MongoRecord}


class User private() extends MongoRecord[User] with ObjectIdPk[User] {
  def meta = User

  object alias extends StringField(this, 255)
  object name extends StringField(this, 255)
  object channel_perms extends MongoMapField[User,  String](this)
  object hostname extends StringField(this, 255)
  object karma extends LongField(this, 0)
  object is_admin extends BooleanField(this, false)
  object logged_on extends DateTimeField(this)
  object logged_out extends DateTimeField(this)
  object last_said extends StringField(this, 255)
  object has_ops extends BooleanField(this, false)
}

object User extends User with MongoMetaRecord[User] {
  override def collectionName = "user"
}