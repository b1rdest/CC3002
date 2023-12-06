package cl.uchile.dcc.citric
package model.board

import cl.uchile.dcc.citric.model.unit._
import scala.collection.mutable.ArrayBuffer

//* In this file, we not only test Chicken.scala, we also test GameUnit's functions*/

class NeutralPanelTest extends munit.FunSuite {
  private val amigo1 = new PlayerCharacter("sapo", 6,6,6,6)
  private val amigo2 = new PlayerCharacter("sepo", 6,6,6,6)
  private val panel1 = new NeutralPanel(new ArrayBuffer[PlayerCharacter](), new ArrayBuffer[Panel]())
  private val panel2 = new NeutralPanel(new ArrayBuffer[PlayerCharacter](), ArrayBuffer[Panel](panel1))
  private var characters = ArrayBuffer[PlayerCharacter](amigo1)
  private var panels = ArrayBuffer[Panel](panel2, panel1)
  private val neutralpanel = new NeutralPanel(characters, panels)
  private val neutralpanelempty = new NeutralPanel

  test("Attributes are correctly set up") {
    assert(neutralpanel.nextPanels == panels)
    assert(neutralpanel.characters == characters)
    assert(neutralpanelempty.nextPanels == ArrayBuffer[Panel]())
    assert(neutralpanelempty.characters == ArrayBuffer[PlayerCharacter]())
  }
  test("stop() function doesn't do anything") {
    neutralpanel.stop(amigo1)
  }

  test("general PanelAbstract functions work properly") {
    //addCharacter
    neutralpanel.addCharacter(amigo2)
    assert(neutralpanel.characters == ArrayBuffer[PlayerCharacter](amigo1, amigo2))
    //removeCharacter
    neutralpanel.removeCharacter(amigo1)
    assert(neutralpanel.characters == ArrayBuffer[PlayerCharacter](amigo2))
    //move
    neutralpanel.addCharacter(amigo1)
    neutralpanel.move(amigo1, 1)
    assert(panel2.characters == ArrayBuffer[PlayerCharacter](amigo1))
    panel2.move(amigo1, moves = 1)
    assert(panel1.characters == ArrayBuffer[PlayerCharacter](amigo1))
    //addPanel
    val panel3 = new NeutralPanel
    neutralpanel.addPanel(panel3)
    assert(neutralpanel.nextPanels(2) == panel3)
    //addPanelatEnd
    neutralpanel.nextPanels = ArrayBuffer[Panel]()
    neutralpanel.addPanelatEnd(panel3)
    assert(neutralpanel.nextPanels(0) == panel3)
    val panel4 = new NeutralPanel
    neutralpanel.addPanelatEnd(panel4)
    assert(neutralpanel.nextPanels(0).nextPanels(0) == panel4)
  }

  test("Tests for battlePlayer() function on abstract class") {
    val neutralPanel = new NeutralPanel()
    assert(neutralPanel.characters.isEmpty)
    neutralPanel.battlePlayer()
  }
}