package cl.uchile.dcc.citric
package model.utility

import model.unit._
import scala.util.Random

class EnemyFactoryTest extends munit.FunSuite {

  val factory: EnemyFactory = new EnemyFactory

  test("Enemy Factory should be able to create all available enemies") {
    factory.random = new Random(44)
    var Enemy: GameUnit = factory.create()
    assert(Enemy.getName == "Chicken")
    Enemy = factory.create()
    assert(Enemy.getName == "Robo Ball")
    Enemy = factory.create()
    assert(Enemy.getName == "Seagull")
  }


  /* Los tests podrían haberse hecho checkeando la clase del enemigo creado, pero
  no supe cómo hacerlo :( */
  test("Enemy Factory should be able to create specific enemies when asked") {
    assert(factory.create("Chicken").getName == "Chicken")
    assert(factory.create("RoboBall").getName == "Robo Ball")
    assert(factory.create("Seagull").getName == "Seagull")
  }
}
