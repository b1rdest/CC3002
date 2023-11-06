package cl.uchile.dcc.citric
package model.board

import cl.uchile.dcc.citric.model.unit.PlayerCharacter

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class PanelTest extends munit.FunSuite {
  /*
  REMEMBER: It is a good practice to use constants for the values that are used in multiple
  tests, so you can change them in a single place.
  This will make your tests more readable, easier to maintain, and less error-prone.
  */
  private val name1 = "testPlayer1"
  private val name2 = "testPlayer2"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private var randomNumberGenerator = new Random()
  /* Add any other constants you need here... */

  /*
  This is the object under test.
  We initialize it in the beforeEach method so we can reuse it in all the tests.
  This is a good practice because it will reset the object before each test, so you don't have
  to worry about the state of the object between tests.
  */
  private var character1: PlayerCharacter = _
  private var character2: PlayerCharacter = _
  private var neutralPanel: NeutralPanel = _
  private var homePanel1: HomePanel = _
  private var homePanel2: HomePanel = _
  private var bonusPanel: BonusPanel = _
  private var dropPanel: DropPanel = _
  private var encounterPanel: EncounterPanel = _

  // This method is executed before each `test(...)` method.
  override def beforeEach(context: BeforeEach): Unit = {
    randomNumberGenerator = new Random()
    character1 = new PlayerCharacter(
      name1,
      maxHp,
      attack,
      defense,
      evasion,
      randomNumberGenerator
    )
    character2 = new PlayerCharacter(
      name2,
      maxHp,
      attack,
      defense,
      evasion,
      randomNumberGenerator
    )
    neutralPanel = new NeutralPanel()
    homePanel1 = new HomePanel(ownerInput = character1)
    homePanel2 = new HomePanel(ownerInput = character2)
    bonusPanel = new BonusPanel()
    dropPanel = new DropPanel()
    encounterPanel = new EncounterPanel()
    neutralPanel.nextPanels = ArrayBuffer(homePanel1)
    homePanel1.nextPanels = ArrayBuffer(bonusPanel)
    bonusPanel.nextPanels = ArrayBuffer(dropPanel)
    dropPanel.nextPanels = ArrayBuffer(encounterPanel)
    encounterPanel.nextPanels = ArrayBuffer(neutralPanel)
  }



  test("Panels are added correctly") {
    assertEquals(neutralPanel.nextPanels(0).nextPanels(0).nextPanels(0).nextPanels(0).nextPanels(0), neutralPanel)
  }
}
