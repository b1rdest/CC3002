package cl.uchile.dcc.citric
package exceptions

class InvalidPanelCreation(message: String) extends Exception ("Panel ".concat(message).concat(" is not defined"))
