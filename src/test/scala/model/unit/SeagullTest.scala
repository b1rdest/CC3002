package cl.uchile.dcc.citric
package model.unit

import scala.util.Random

//* In this file, we not only test Chicken.scala, we also test GameUnit's functions*/

class SeagullTest extends munit.FunSuite {
  private val name = "Seagull"
  private val maxHp = 3
  private val ATK = 1
  private val DEF = -1
  private val EVA = -1
  private val randomNumberGenerator = new Random()

  private var amigo = new Seagull()

  override def beforeEach(context: BeforeEach): Unit = {
    amigo = new Seagull(
      name,
      maxHp,
      ATK,
      DEF,
      EVA,
      randomNumberGenerator
    )
  }

  test ("Stats are correct") {
    assert(amigo.name == name)
    assert(amigo.maxHp == maxHp)
    assert(amigo.ATK == ATK)
    assert(amigo.DEF == DEF)
    assert(amigo.EVA == EVA)
  }


  test("GameUnit can attack") {
    assert(amigo.attack() > -1)
    amigo.setAlive(false)
    assert(amigo.attack() == 0)
  }

  test("GameUnit can defend") {
    val currenthp = amigo.getHP
    amigo.defend(1)
    assert(amigo.getHP < currenthp)
    amigo.evade(1)
    assert(amigo.getHP < currenthp)

  }

  test("GameUnit can evade") {
    val currenthp = amigo.getHP
    amigo.randomNumberGenerator.setSeed(1)
    amigo.evade(1)
    assert(amigo.getHP == currenthp)
    amigo.randomNumberGenerator.setSeed(1)
    amigo.evade(6)
    assert(amigo.getHP < currenthp)
  }

  test("KO() sets status to not alive and properly returns stars") {
    assert(amigo.KO() == 2)
    assert(!amigo.getAlive)
  }
}

