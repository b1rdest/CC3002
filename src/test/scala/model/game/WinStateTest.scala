package cl.uchile.dcc.citric
package model.game

import model.unit.PlayerCharacter

class WinStateTest extends munit.FunSuite {
  val controller = new GameController
  val winner = new PlayerCharacter("Bob",1,1,1,1, controllerInput = controller)

  test("WinState is the final state of the game, therefore it doesnt transition to any other state or modifies any other variable") {
    controller.state = new WinState(controller, winner)
    controller.state.rollDice() //does nothing
    controller.state.doEffect() //prints the name of the winner
  }
}
