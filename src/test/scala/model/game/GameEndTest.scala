package cl.uchile.dcc.citric
package model.game

import model.unit.PlayerCharacter

class GameEndTest extends munit.FunSuite {
  val controller = new GameController

  test("GameEnd is a placeholder state, therefore it does nothing") {
    controller.state = new GameEnd(controller)
    controller.state.rollDice()
    controller.state.doEffect()
  }
}
