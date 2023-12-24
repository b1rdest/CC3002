package cl.uchile.dcc.citric
package model.utility

import scala.util.Random
import model.unit.{Chicken, GameUnit, RoboBall, Seagull}
import cl.uchile.dcc.citric.exceptions.InvalidEnemyCreation

/* Class made for returning new enemies with two methods: one that creates a random creature, and another one that creates a specific enemy.*/
class EnemyFactory extends Factory {
  var random: Random = new Random()
  
  /* Creates a random enemy from the implemented enemies below. Must be updated every time a new enemy is created.*/
  def create(): GameUnit = {
    val decision: Int = random.nextInt(3)
    if (decision == 0) { //Creates a Chicken
      create("Chicken")
    }
    else if (decision == 1) { //Creates a RoboBall
      create("RoboBall")
    }
    else { //Creates a Seagull
      create("Seagull")
    }
  }

  /* Overloaded function to create a specific enem. yMust be updated every time a new enemy is created. */
  def create(creature: String): GameUnit = {
    if (creature == "Chicken") { //Creates a Chicken
      new Chicken()
    }
    else if (creature == "RoboBall") { //Creates a RoboBall
      new RoboBall()
    }
    else if (creature == "Seagull"){ //Creates a Seagull
      new Seagull()
    }
    else {
      throw new InvalidEnemyCreation(creature)
    }
  }
}
