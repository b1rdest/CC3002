package cl.uchile.dcc.citric
package model.unit

import scala.util.Random

//* In this file, we not only test Chicken.scala, we also test GameUnit's functions*/

class RoboBallTest extends munit.FunSuite {
  private val name = "Robo Ball"
  private val maxHp = 3
  private val ATK = -1
  private val DEF = 1
  private val EVA = -1
  private val randomNumberGenerator = new Random()

  private var amigo = new RoboBall()

  override def beforeEach(context: BeforeEach): Unit = {
    amigo = new RoboBall(
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

  test("KO() sets status to not alive and properly returns stars") {
    assert(amigo.KO() == 2)
    assert(!amigo.getAlive)
  }
}
