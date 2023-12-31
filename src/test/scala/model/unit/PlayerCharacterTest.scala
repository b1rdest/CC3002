package cl.uchile.dcc.citric
package model.unit

import cl.uchile.dcc.citric.model.board.NeutralPanel
import cl.uchile.dcc.citric.model.game.GameController

import scala.util.Random
import cl.uchile.dcc.citric.model.norma._
import cl.uchile.dcc.citric.model.utility.InputHandler

import scala.collection.mutable.ArrayBuffer

class PlayerCharacterTest extends munit.FunSuite {
  /*
  REMEMBER: It is a good practice to use constants for the values that are used in multiple
  tests, so you can change them in a single place.
  This will make your tests more readable, easier to maintain, and less error-prone.
  */
  private val name = "testPlayer"
  private val maxHp = 10
  private val ATK = 1
  private val DEF = 1
  private val EVA = 1
  private var randomNumberGenerator = new Random(11)
  /* Add any other constants you need here... */

  /*
  This is the object under test.
  We initialize it in the beforeEach method so we can reuse it in all the tests.
  This is a good practice because it will reset the object before each test, so you don't have
  to worry about the state of the object between tests.
  */
  private var character: PlayerCharacter = _  // <- x = _ is the same as x = null
  /* Add any other variables you need here... */

  // This method is executed before each `test(...)` method.
  override def beforeEach(context: BeforeEach): Unit = {
    randomNumberGenerator = new Random(11)
    character = new PlayerCharacter(
      name,
      maxHp,
      ATK,
      DEF,
      EVA,
      randomNumberGenerator
    )
  }

  test("A character should have correctly set their attributes") {
    assertEquals(character.name, name)
    assertEquals(character.maxHp, maxHp)
    assertEquals(character.ATK, ATK)
    assertEquals(character.DEF, DEF)
    assertEquals(character.EVA, EVA)
    assertEquals(character.randomNumberGenerator, randomNumberGenerator)
  }

  // Two ways to test randomness (you can use any of them):

  // 1. Test invariant properties, e.g. the result is always between 1 and 6.
  test("A character should be able to roll a dice") {
    for (_ <- 1 to 10) {
      assert(character.rollDice >= 1 && character.rollDice <= 6)
    }
  }

  // 2. Set a seed and test the result is always the same.
  // A seed sets a fixed succession of random numbers, so you can know that the next numbers
  // are always the same for the same seed.
  test("A character should be able to roll a dice with a fixed seed") {
    val other =
      new PlayerCharacter(name, maxHp, ATK, DEF, EVA, new Random(11))
    for (_ <- 1 to 10) {
      assertEquals(character.rollDice(), other.rollDice())
    }
  }

  class InputHandlerTest extends InputHandler {
    override def askForInput(possibleAnswers: ArrayBuffer[String], message: String): String = {
      "s"
    }
  }

  test("KO() should return stars if player is alive, and 0 if they are not") {
    assert(character.KO() == character.getStars/2)
    assert(character.KO() == 0)
    character.randomNumberGenerator.setSeed(2)
    assert(character.KO() == 0)
  }
  test("NormaCheck() runs correctly when conditions are not fulfilled") {
    character.setStars(-1)
    character.setWins(-1)
    character.getNorma.inputHandler = new InputHandlerTest
    character.NormaCheck()
    assert((character.getNorma).isInstanceOf[Norma1])
    character.setStars(99)
    character.setWins(99)
    val norma2 = new Norma2(character, new GameController)
    character.setNorma(norma2)
    character.getNorma.inputHandler = new InputHandlerTest
    character.NormaCheck()
    assert((character.getNorma).isInstanceOf[Norma3])
  }

  test("Incomplete Functions") {
    character.Battle(character)
  }

  test("Receive Wins correctly allocates Wins depending on the type of defeated unit") {
    val bellaco = new Chicken()
    val idiot = new PlayerCharacter(
      name,
      maxHp,
      ATK,
      DEF,
      EVA,
      randomNumberGenerator
    )
    character.receiveWins(bellaco)
    assert(character.getWins == 1)
    character.receiveWins(idiot)
    assert(character.getWins == 3)
  }
  test("A character should be able to delegate move responsability to Panel") {
    val panel = new NeutralPanel()
    character.currentPanel = panel
    character.move(0)
    assert(character.currentPanel == panel)
  }

}
