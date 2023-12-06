package cl.uchile.dcc.citric
package exceptions

class InvalidStateChange (message: String) extends Exception ("Invalid State Transition: ".concat(message))
