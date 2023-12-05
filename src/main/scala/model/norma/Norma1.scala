package cl.uchile.dcc.citric
package model.norma

import model.game.GameController
import model.unit.PlayerCharacter

import cl.uchile.dcc.citric.model.utility.InputHandler

class Norma1(playerInput: PlayerCharacter, controllerInput: GameController) extends NormaAbstract {
  val level = 1
  var starGoal: Int = 0
  var winGoal: Int = 0
  val player: PlayerCharacter = playerInput
  val controller: GameController = controllerInput
  var inputHandler= new InputHandler

  def increase(wins: Int, stars: Int): Norma = {
    if (wins >= winGoal || stars >= starGoal) { //*Will be replaced by the condition chosen by the player to acquire Norma */
      val outNorma = new Norma2(this.player, controller)
      outNorma.inputHandler = this.inputHandler //this is for testing purposes
      outNorma.updateGoal()
      outNorma
    }
    else { //* If the condition doesn't succeed, it will simply return itself
      this
    }
  }


}
