package cl.uchile.dcc.citric
package model.norma

import model.game.GameController
import model.unit.PlayerCharacter

import cl.uchile.dcc.citric.model.utility.InputHandler

import scala.collection.mutable.ArrayBuffer

class Norma2Test extends munit.FunSuite {
  private val level = 2
  private val starGoal = 10
  private val winGoal = 1

  var norma2: Norma = _
  var norma3: Norma = _

  private val player: PlayerCharacter = new PlayerCharacter("Bob", 1, 1, 1, 1)
  private val controller: GameController = new GameController

  override def beforeEach(context: BeforeEach): Unit = {
    norma2 = new Norma2(player, controller)
    norma3 = new Norma3(player, controller)
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
    assertEquals(norma2.getLevel(), level)
    assertEquals(norma2.getStarGoal(), starGoal)
    assertEquals(norma2.getWinsGoal(), winGoal)
    assertEquals(norma2.getPlayer(), player)
    assertEquals(norma2.getController(), controller)
  }

  test("A Norma increase should either return itself or return a norma of the next level") {
    norma2.inputHandler = new InputHandlerTestS
    assertEquals(norma2.increase(-1,-1), norma2)
    assert(norma2.increase(999,999).isInstanceOf[Norma3])
  }

}