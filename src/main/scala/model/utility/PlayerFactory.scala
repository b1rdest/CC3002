package cl.uchile.dcc.citric
package model.utility

import model.unit.PlayerCharacter

import cl.uchile.dcc.citric.model.game.GameController

/* Dynamic player constructor that asks the player for the variables of their character */
class PlayerFactory(controller: GameController) extends Factory {
  var inputHandler: InputHandler = new InputHandler

  /* Setter exclusively made for testing ease*/
  //def setHandler(newHandler: InputHandler): Unit = {
  //  this.inputHandler = newHandler
  //}

  def create(): PlayerCharacter = {
    val name = inputHandler.askForInput("Please input name for player: ")
    /* For now, all characters have the following stats:
    * HP = 3, ATK = 1, DEF = 1, EVD = 1*/
    new PlayerCharacter(name, 3, 1, 1, 1, controllerInput = controller)
  }
}
