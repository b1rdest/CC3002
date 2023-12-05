package cl.uchile.dcc.citric
package model.norma

import model.unit.PlayerCharacter

import cl.uchile.dcc.citric.model.game.GameController
import cl.uchile.dcc.citric.model.utility.InputHandler

import scala.collection.mutable.ArrayBuffer

class Norma1Test extends munit.FunSuite {
  private val level = 1
  private val starGoal = 0
  private val winGoal = 0

  var norma: Norma = _
  var norma2: Norma = _
  private val player: PlayerCharacter = new PlayerCharacter("Bob",1,1,1,1)
  private val controller: GameController = new GameController

  override def beforeEach(context: BeforeEach): Unit = {
    norma = new Norma1(player, controller)
    norma2 = new Norma2(player, controller)
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
    assertEquals(norma.getLevel(), level)
    assertEquals(norma.getStarGoal(), starGoal)
    assertEquals(norma.getWinsGoal(), winGoal)
    assertEquals(norma.getPlayer(), player)
    assertEquals(norma.getController(), controller)
  }

  test("A Norma increase should either return itself or return a norma of the next level") {
    norma.inputHandler = new InputHandlerTestS
    assertEquals(norma.increase(-1,-1), norma)
    assert(norma.increase(1,1).isInstanceOf[Norma2])
  }

}