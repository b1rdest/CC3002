package cl.uchile.dcc.citric
package model.game

import model.board._
import model.utility._

import cl.uchile.dcc.citric.model.unit.PlayerCharacter
class ChapterStartTest extends munit.FunSuite {
  val controller = new GameController
  val player = new PlayerCharacter("Bob", 1, 1, 1, 1, controllerInput = controller)
  controller.turnOrder.enqueue(player)
  val chapterStart = new ChapterStart(controller)
  controller.state = chapterStart

  test("ChapterStart correctly sets up the next state, depending on chapters") {
    controller.chapters = 100
    chapterStart.doEffect()
    assert(controller.state.isInstanceOf[GameEnd])
    controller.chapters = 0
    controller.changeState(chapterStart)
    chapterStart.doEffect()
    assert(controller.state.isInstanceOf[PlayerTurn])
  }

  test("rollDice does nothing") {
    assert(chapterStart.rollDice().isInstanceOf[Unit])
  }
}
