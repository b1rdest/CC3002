package cl.uchile.dcc.citric
package exceptions

import model.unit.PlayerCharacter

class AttackDeadUnitTest extends munit.FunSuite {
  private val deadPlayer = new PlayerCharacter("Bob",1,1,1,1)
  deadPlayer.KO()
  private val alivePlayer = new PlayerCharacter("Alice",1,1,1,1)

  test(
    "The message is thrown if a unit attacks another unit that is dead"
  ) {
    interceptMessage[AttackDeadUnit]("Dead unit cannot be attacked: Bob is dead and cannot defend") {
      deadPlayer.defend(1)
    }
  }
}
