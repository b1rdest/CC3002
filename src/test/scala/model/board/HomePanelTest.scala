package cl.uchile.dcc.citric
package model.board

import model.unit._

import scala.collection.mutable.ArrayBuffer

//* In this file, we not only test Chicken.scala, we also test GameUnit's functions*/

class HomePanelTest extends munit.FunSuite {
  private val amigo1 = new PlayerCharacter("sapo", 6, 6, 6, 6)
  private val amigo2 = new PlayerCharacter("sepo", 6, 6, 6, 6)
  private val panel1 = new NeutralPanel()
  private val homePanel = new HomePanel(ArrayBuffer[PlayerCharacter](amigo1), ArrayBuffer[Panel](panel1), amigo1)
  private var characters = ArrayBuffer[PlayerCharacter](amigo1)
  private var panels = ArrayBuffer[Panel](panel1)
  private val homePanelEmpty = new HomePanel(ownerInput = amigo1)

  test("Attributes are correctly set up") {
    assert(homePanel.nextPanels == panels)
    assert(homePanel.characters == characters)
    assert(homePanel.getOwner() == amigo1)
    assert(homePanelEmpty.nextPanels == ArrayBuffer[Panel]())
    assert(homePanelEmpty.characters == ArrayBuffer[PlayerCharacter]())
  }

  test("move function lets the player stay only if they are the owner") {
    homePanelEmpty.move(amigo1, 0, "Y")
    assert(homePanel.characters == ArrayBuffer[PlayerCharacter](amigo1))
    homePanelEmpty.removeCharacter(amigo1)
    homePanelEmpty.move(amigo1, 2, "Y")
    assert(homePanel.characters == ArrayBuffer[PlayerCharacter](amigo1))
    homePanelEmpty.removeCharacter(amigo1)
    homePanelEmpty.move(amigo1, 2, "N")
    assert(homePanelEmpty.characters == ArrayBuffer[PlayerCharacter]())
    homePanelEmpty.nextPanels = ArrayBuffer[Panel](panel1)
    homePanelEmpty.move(amigo2, 2, "Y")
    assert(homePanelEmpty.characters == ArrayBuffer[PlayerCharacter]())
  }

  test("stop() function correctly calls for normaCheck()") {
    val currenthp = amigo1.getHP
    val currentnorma = amigo1.getNorma
    amigo1.setStars(-1)
    amigo1.setWins(-1)
    homePanel.stop(amigo1)
    assert(amigo1.getHP == currenthp + 1)
    assert(amigo1.getNorma == currentnorma)
  }
}