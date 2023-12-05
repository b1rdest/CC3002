package cl.uchile.dcc.citric
package model.norma

import model.game.GameController
import model.unit.PlayerCharacter

import cl.uchile.dcc.citric.model.utility.InputHandler

class Norma6(playerInput: PlayerCharacter, controllerInput: GameController) extends NormaAbstract {
  val level = 6
  var starGoal: Int = 200
  var winGoal: Int = 14
  val player: PlayerCharacter = playerInput
  val controller: GameController = controllerInput
  var inputHandler: InputHandler = new InputHandler

  def increase(wins: Int, stars: Int): Norma = {
    if (wins >= winGoal || stars >= starGoal) { //*
      //player.update()
      this // At this point, the player wins, update the controller.
    }
    else {
      this
    }
  }
}
