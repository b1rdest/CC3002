package cl.uchile.dcc.citric
package model.utility

import model.unit._

import model.board._

import scala.util.Random

class RandomPanelFactoryTest extends munit.FunSuite {

  val factory: RandomPanelFactory= new RandomPanelFactory

  test("Random Panel Factory should be able to create all available panels") {
    factory.random = new Random(4483)
    var Panel: Panel = factory.create()
    assert(Panel.isInstanceOf[NeutralPanel])
    Panel = factory.create()
    assert(Panel.isInstanceOf[BonusPanel])
    Panel = factory.create()
    assert(Panel.isInstanceOf[DropPanel])
    Panel = factory.create()
    assert(Panel.isInstanceOf[EncounterPanel])
    Panel = factory.create()
  }


  test("Random Panel Factory should be able to create specific panels when asked") {
    assert(factory.create("Neutral").isInstanceOf[NeutralPanel])
    assert(factory.create("Bonus").isInstanceOf[BonusPanel])
    assert(factory.create("Drop").isInstanceOf[DropPanel])
    assert(factory.create("Encounter").isInstanceOf[EncounterPanel])
  }
}
