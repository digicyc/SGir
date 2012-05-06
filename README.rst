=========================
 SGIR -- IRC Bot in Scala
=========================
Just a simple irc bot written in Scala.

|sgir|

Basics of SGir's Core
=====================
The core is mainly just this event driven machine in which it
fires off events for certain things and sends each event down the chain
of existing event handlers.
  TODO: Add in PluginManager similar to his BigBrother JGir.

Commands
========
For the most part SGir helps their owner by keeping track of conversations
and managing users in a channel. SGir will also protect their Owner best they can. (If they have ops)

Reasons
=======
- Was written to help support a software company by tracking bugs via FlySpray(gone now)
- And to Jabber alert certain developers when certain problems arose.(Replaced with nagios now).
- Most of all.. to learn Scala with a MongoDB backend.

License
=======
Copyright (c) 2010 - 2012 Aaron Allred

Published under the MIT License, see LICENSE_

.. |sgir| image:: https://github.com/digicyc/SGir/raw/master/gir_sit.jpg
.. _LICENSE: https://github.com/digicyc/SGir/blob/master/LICENSE.rst
