package cl.uchile.dcc.citric
package exceptions

class InvalidEnemyCreation (message: String) extends Exception ("Enemy ".concat(message).concat(" is not defined"))
