package cl.uchile.dcc.citric
package model.unit

import scala.util.Random

//* In this file, we not only test Chicken.scala, we also test GameUnit's functions*/

class ChickenTest extends munit.FunSuite {
  private val name = "Chicken"
  private val maxHp = 3
  private val ATK = -1
  private val DEF = -1
  private val EVA = 1
  private val randomNumberGenerator = new Random()

  private var amigo = new Chicken()

  override def beforeEach(context: BeforeEach): Unit = {
    amigo = new Chicken(
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

  test ("GameUnit functions are well implemented") {
    assert(amigo.attack() > -1)
    amigo.setAlive(false)
    assert(amigo.attack() == 0)
    val currenthp = amigo.getHP
    amigo.defend(1)
    assert(amigo.getHP < currenthp)
    amigo.evade(1)
    assert(amigo.getHP < currenthp)

  }

  test("KO() sets status to not alive and properly returns stars") {
    assert(amigo.KO() == 3)
    assert(!amigo.getAlive)
  }
}