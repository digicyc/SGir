=========================
 SGIR -- IRC Bot in Scala
=========================

Just a simple bot written in Scala.

Basics of SGir's Core
=====================
The core is mainly just this event driven machine in which it
fires off events for certain things and sends each event down the chain
of existing event handlers, including any plugins loaded up.


Reasons
=======
Main reason for SGir was to give live updates to an
irc channel of my companies current print status'.
Basically he connects to a VDP Print Output Engine via
a SOAP API and gives live feeds to the any specified #channel.
