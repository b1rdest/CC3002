package cl.uchile.dcc.citric
package model.utility

import model.board._

class BoardFactoryTest extends munit.FunSuite {

  val factory = new BoardFactory

  test("Board Factory should be able to create a sequence of connected panels") {
    val sequence = factory.create(5)
    var next = sequence
    for (i <- Range.inclusive(0,3)) {
      assert(next.isInstanceOf[Panel])
      next = next.nextPanels(0)
    }
  }
  test("Board Factory should also be able to create a single panel") {
    assert(factory.create().isInstanceOf[Panel])
  }
}
