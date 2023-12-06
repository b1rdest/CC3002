package cl.uchile.dcc.citric
package exceptions

class AttackDeadUnit (message: String) extends Exception ("Dead unit cannot be attacked: ".concat(message))