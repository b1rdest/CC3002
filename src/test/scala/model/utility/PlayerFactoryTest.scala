package cl.uchile.dcc.citric
package model.utility

import model.unit.PlayerCharacter

import model.game.GameController

class PlayerFactoryTest extends munit.FunSuite {

  val name = "El pepe"
  val controller = new GameController
  class InputHandlerTest extends InputHandler {
    override def askForInput(message: String): String = "El pepe"
  }
  val inputHandlerElPepe = new InputHandlerTest
  val factory:PlayerFactory = new PlayerFactory(controller)
  factory.inputHandler = new InputHandlerTest

  test("Player Factory should correctly name the characters") {
    val player:PlayerCharacter = factory.create()
    assert(player.name == "El pepe")
  }

  test("Player Factory should correctly assign stats") {
    val player: PlayerCharacter = factory.create()
    assert(player.maxHp == 3)
    assert(player.ATK == 1)
    assert(player.DEF == 1)
    assert(player.EVA == 1)
    assert(player.controller == controller)
  }
}
