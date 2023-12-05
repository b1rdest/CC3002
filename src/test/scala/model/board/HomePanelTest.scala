package cl.uchile.dcc.citric
package model.board

import model.unit._
import model.norma

import cl.uchile.dcc.citric.model.norma.{Norma1, Norma2}
import cl.uchile.dcc.citric.model.utility.InputHandler

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
    assert(homePanel.getOwner == amigo1)
    assert(homePanelEmpty.nextPanels == ArrayBuffer[Panel]())
    assert(homePanelEmpty.characters == ArrayBuffer[PlayerCharacter]())
  }

  /* Utility classes for input testing */
  class InputHandlerTestY extends InputHandler {
    override def askForInput(possibleAnswers: ArrayBuffer[String], message: String): String = {
      "Y"
    }
  }
  class InputHandlerTestN extends InputHandler {
    override def askForInput(possibleAnswers: ArrayBuffer[String], message: String): String = {
      "N"
    }
  }

  test("move function lets the player stay only if they are the owner") {


    homePanelEmpty.move(amigo1, 0)
    assert(homePanel.characters == ArrayBuffer[PlayerCharacter](amigo1))
    homePanelEmpty.removeCharacter(amigo1)

    homePanelEmpty.setHandler(new InputHandlerTestY)
    homePanelEmpty.move(amigo1, 1)
    assert(homePanel.characters == ArrayBuffer[PlayerCharacter](amigo1))
    homePanelEmpty.removeCharacter(amigo1)

    homePanelEmpty.setHandler(new InputHandlerTestN)
    homePanelEmpty.nextPanels = ArrayBuffer[Panel](panel1)
    homePanelEmpty.move(amigo1, 1)
    assert(homePanelEmpty.characters == ArrayBuffer[PlayerCharacter]())

    homePanelEmpty.setHandler(new InputHandlerTestY)
    homePanelEmpty.move(amigo2, 1)
    assert(homePanelEmpty.characters == ArrayBuffer[PlayerCharacter]())
  }

  test("setters and getters") {
    assert(homePanel.getOwner == amigo1 )
    val inputHandler = new InputHandlerTestY
    homePanel.setHandler(inputHandler)
  }

  test("stop() function correctly calls for normaCheck()") {
    val currenthp = amigo1.getHP
    amigo1.setNorma(new Norma1)
    amigo1.setStars(-1)
    amigo1.setWins(-1)
    homePanel.stop(amigo1)
    assert(amigo1.getHP == currenthp + 1)
    assert(amigo1.getNorma.isInstanceOf[Norma1])

    homePanelEmpty.removeCharacter(amigo1)
    //amigo1.setNorma(new Norma1)
    amigo1.setStars(99)
    amigo1.setWins(99)
    homePanel.stop(amigo1)
    assert(amigo1.getNorma.isInstanceOf[Norma2])
  }
}