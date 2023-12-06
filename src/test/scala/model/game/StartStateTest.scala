package cl.uchile.dcc.citric
package model.game

import model.board._
import model.unit._
import model.utility._

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class StartStateTest extends munit.FunSuite {
  val controller = new GameController
  val startState = new StartState(controller)
  var random = new Random(4483)

  override def beforeEach(context: BeforeEach): Unit = {

  }

  class InputHandlerTest extends InputHandler {
    override def askForInput(message: String): String = {
      "Sapo".concat(random.nextInt(4).toString)
    }
  }

  test("start function correctly assigns player, creates the board, and switches to new state") {
    startState.inputHandler = new InputHandlerTest
    random = new Random(4483)
    controller.chapters = 100
    startState.doEffect()
    //controller.players is correctly assigned
    for (i <- Range.inclusive(0,3)) {
      assert(controller.players(i).getName == "Sapo".concat(i.toString))
    }
    //controller.turnOrder is correctly set up
    for (i <- Range.inclusive(0, 3)) {
      assert(controller.turnOrder.dequeue().getName == "Sapo".concat((i).toString))
    }

    /*controller.board is correctly set up, it has no discontinuities and
    * the cycle is complete. Also checks that there are exactly only four
    * homePanels, one for each player*/
    var next = controller.currentPanel
    var cantidadHomePanels: Int = 0
    for(i <- Range.inclusive(0,30)) {
      assert(next.isInstanceOf[Panel])
      assert(next.nextPanels.nonEmpty)
      if (next.isInstanceOf[HomePanel]) {
        cantidadHomePanels+=1
        assert(next.characters(0).getName == "Sapo".concat((i/8).toString))
      }
      next = next.nextPanels(0)
    }
    assert(next.nextPanels(0) == controller.currentPanel) //assertamos que dimos la vuelta
    assert(cantidadHomePanels == 4) //assert that there are only 4 homePanels
    //assert(controller.state.isInstanceOf[GameEnd])
  }

  test("rollDice does nothing") {
    assert(startState.rollDice().isInstanceOf[Unit])
  }

}