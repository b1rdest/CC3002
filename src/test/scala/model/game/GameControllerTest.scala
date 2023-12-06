package cl.uchile.dcc.citric
package model.game

import model.board._
import model.utility._

import cl.uchile.dcc.citric.model.unit.PlayerCharacter

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class GameControllerTest extends munit.FunSuite {
  val controller = new GameController
  val random = new Random(4483)

  test("GameController has it's variables correctly set up") {

  }

  class InputHandlerTest extends InputHandler {
    override def askForInput(message: String): String = {
      "Sapo".concat(random.nextInt(4).toString)
    }
  }

  test("GameController.nextTurnPlayer() returns the corresponding player") {
    val factory = new PlayerFactory(controller)
    factory.inputHandler = new InputHandlerTest
    for (i <- Range.inclusive(0,3)) {
      controller.turnOrder.enqueue(factory.create())
    }
    for (i <- Range.inclusive(0,3)) {
      assert(controller.nextTurnPlayer().getName == "Sapo".concat(i.toString))
    }
  }
 test("GameController.rollDice simply rolls the dice of its current state") {
   controller.changeState(new ChapterStart(controller)) //for this state, rollDIce does nothing
   controller.rollDice()
 }

  test("GameController can trigger the win condition") {
    controller.updateWinner(new PlayerCharacter("Bob", 1, 1, 1, 1, controllerInput = controller))
    assert(controller.state.isInstanceOf[WinState])
  }

}