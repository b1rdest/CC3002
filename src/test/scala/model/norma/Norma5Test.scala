package cl.uchile.dcc.citric
package model.norma

import model.game.GameController
import model.unit.PlayerCharacter

import cl.uchile.dcc.citric.model.utility.InputHandler

import scala.collection.mutable.ArrayBuffer

class Norma5Test extends munit.FunSuite {
  private val level = 5
  private val starGoal = 120
  private val winGoal = 10

  var norma5: Norma = _
  var norma6: Norma = _
  private val player: PlayerCharacter = new PlayerCharacter("Bob", 1, 1, 1, 1)
  private val controller: GameController = new GameController

  override def beforeEach(context: BeforeEach): Unit = {
    norma5 = new Norma5(player, controller)
    norma6 = new Norma6(player, controller)
  }

  class InputHandlerTestS extends InputHandler {
    override def askForInput(possibleAnswers: ArrayBuffer[String], message: String): String = {
      "s"
    }
  }

  class InputHandlerTestW extends InputHandler {
    override def askForInput(possibleAnswers: ArrayBuffer[String], message: String): String = {
      "w"
    }
  }

  test("A Norma should have correctly set their attributes") {
    assertEquals(norma5.getLevel(), level)
    assertEquals(norma5.getStarGoal(), starGoal)
    assertEquals(norma5.getWinsGoal(), winGoal)
    assertEquals(norma5.getPlayer(), player)
    assertEquals(norma5.getController(), controller)
  }

  test("A Norma increase should either return itself or return a norma of the next level") {
    norma5.inputHandler = new InputHandlerTestS
    assertEquals(norma5.increase(-1,-1), norma5)
    assert(norma5.increase(999,999).isInstanceOf[Norma6])
  }

}