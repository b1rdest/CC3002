package cl.uchile.dcc.citric
package model.norma

import model.game.GameController
import model.unit.PlayerCharacter

class Norma6Test extends munit.FunSuite {
  private val level = 6
  private val starGoal = 200
  private val winGoal = 14

  var norma6: Norma = _
  private val player: PlayerCharacter = new PlayerCharacter("Bob", 1, 1, 1, 1)
  private val controller: GameController = new GameController

  override def beforeEach(context: BeforeEach): Unit = {
    norma6 = new Norma6(player, controller)
  }


  test("A Norma should have correctly set their attributes") {
    assertEquals(norma6.getLevel(), level)
    assertEquals(norma6.getStarGoal(), starGoal)
    assertEquals(norma6.getWinsGoal(), winGoal)
  }

  test("A Norma increase should either return itself or return a norma of the next level") {
    assertEquals(norma6.increase(-1,-1), norma6)
    assert(norma6.increase(999,999).isInstanceOf[Norma6])
    assert(norma6.increase(-1, -1).isInstanceOf[Norma6])
  }

}