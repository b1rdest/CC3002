package cl.uchile.dcc.citric
package model.norma

import model.game.GameController
import model.unit.PlayerCharacter

class Norma4Test extends munit.FunSuite {
  private val level = 4
  private val starGoal = 70
  private val winGoal = 6

  var norma4: Norma = _
  var norma5: Norma = _
  private val player: PlayerCharacter = new PlayerCharacter("Bob", 1, 1, 1, 1)
  private val controller: GameController = new GameController

  override def beforeEach(context: BeforeEach): Unit = {
    norma4 = new Norma4(player, controller)
    norma5 = new Norma5(player, controller)
  }


  test("A Norma should have correctly set their attributes") {
    assertEquals(norma4.getLevel(), level)
    assertEquals(norma4.getStarGoal(), starGoal)
    assertEquals(norma4.getWinsGoal(), winGoal)
  }

  test("A Norma increase should either return itself or return a norma of the next level") {
    assertEquals(norma4.increase(-1,-1), norma4)
    assert(norma4.increase(999,999).isInstanceOf[Norma5])
  }

}