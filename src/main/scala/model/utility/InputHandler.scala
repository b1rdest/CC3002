package cl.uchile.dcc.citric
package model.utility

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn.readLine


//Utility class for all terminal inputs
//can be overriden for testing that requires Player Input
//Avoids code duplication for prompts.
class InputHandler {
  /* possibleAnswers: receives an Array of Strings. Then, the methods asks for an input
  that exists in the array. If not, it asks again. If it does, then returns it.
  message: the prompt for the readline */
  def askForInput(possibleAnswers: ArrayBuffer[String], message: String): String = {
    var decision: String = readLine(message)
    while (possibleAnswers.contains(decision)) {
      decision = readLine(message)
    }
    decision
  }
  /* Prompts the user for a variable and returns it. */
  def askForInput(message: String): String = {
    var decision: String = readLine(message)
    decision
  }
}
