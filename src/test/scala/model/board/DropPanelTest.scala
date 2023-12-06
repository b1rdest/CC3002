package cl.uchile.dcc.citric
package model.board

import model.unit._

import scala.collection.mutable.ArrayBuffer

//* In this file, we not only test Chicken.scala, we also test GameUnit's functions*/

class DropPanelTest extends munit.FunSuite {
  private val amigo1 = new PlayerCharacter("sapo", 6, 6, 6, 6)
  private val panel1 = new NeutralPanel()
  private val dropPanel = new DropPanel(ArrayBuffer[PlayerCharacter](amigo1), ArrayBuffer[Panel](panel1))
  private var characters = ArrayBuffer[PlayerCharacter](amigo1)
  private var panels = ArrayBuffer[Panel](panel1)
  private val dropPanelEmpty = new DropPanel()

  test("Attributes are correctly set up") {
    assert(dropPanel.nextPanels == panels)
    assert(dropPanel.characters == characters)
    assert(dropPanelEmpty.nextPanels == ArrayBuffer[Panel]())
    assert(dropPanelEmpty.characters == ArrayBuffer[PlayerCharacter]())
  }
  test("stop() function substracts stars") {
    val currentstars = amigo1.getStars
    dropPanel.stop(amigo1)
    assert(amigo1.getStars <= currentstars)
  }
}