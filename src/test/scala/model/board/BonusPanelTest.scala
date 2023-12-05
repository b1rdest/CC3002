package cl.uchile.dcc.citric
package model.board

import model.unit._
import scala.collection.mutable.ArrayBuffer

//* In this file, we not only test Chicken.scala, we also test GameUnit's functions*/

class BonusPanelTest extends munit.FunSuite {
  private val amigo1 = new PlayerCharacter("sapo", 6, 6, 6, 6)
  private val panel1 = new NeutralPanel()
  private val bonusPanel = new BonusPanel(ArrayBuffer[PlayerCharacter](amigo1), ArrayBuffer[Panel](panel1))
  private val characters = ArrayBuffer[PlayerCharacter](amigo1)
  private val panels = ArrayBuffer[Panel](panel1)
  private val bonusPanelEmpty = new BonusPanel()

  test("Attributes are correctly set up") {
    assert(bonusPanel.nextPanels == panels)
    assert(bonusPanel.characters == characters)
    assert(bonusPanelEmpty.nextPanels == ArrayBuffer[Panel]())
    assert(bonusPanelEmpty.characters == ArrayBuffer[PlayerCharacter]())
  }
  test("stop() function gives stars") {
    val currentstars = amigo1.getStars
    bonusPanel.stop(amigo1)
    assert(amigo1.getStars > currentstars)
  }
}