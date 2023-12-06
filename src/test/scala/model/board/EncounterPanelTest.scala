package cl.uchile.dcc.citric
package model.board

import model.unit._

import scala.collection.mutable.ArrayBuffer

//* In this file, we not only test Chicken.scala, we also test GameUnit's functions*/

class EncounterPanelTest extends munit.FunSuite {
  private val amigo1 = new PlayerCharacter("sapo", 6, 6, 6, 6)
  private val panel1 = new NeutralPanel()
  private val encounterPanel = new EncounterPanel(ArrayBuffer[PlayerCharacter](amigo1), ArrayBuffer[Panel](panel1))
  private var characters = ArrayBuffer[PlayerCharacter](amigo1)
  private var panels = ArrayBuffer[Panel](panel1)
  private val encounterPanelEmpty = new EncounterPanel()

  test("Attributes are correctly set up") {
    assert(encounterPanel.nextPanels == panels)
    assert(encounterPanel.characters == characters)
    assert(encounterPanelEmpty.nextPanels == ArrayBuffer[Panel]())
    assert(encounterPanelEmpty.characters == ArrayBuffer[PlayerCharacter]())
  }
  test("stop() function calls does nothing") {
    encounterPanel.stop(amigo1)
  }
}