package cl.uchile.dcc.citric
package model.utility

import scala.util.Random
import model.unit.{Chicken, GameUnit, RoboBall, Seagull}

import cl.uchile.dcc.citric.exceptions.InvalidEnemyCreation

class EnemyFactory extends Factory {
  /* Creates a random enemy */
  var random: Random = new Random()
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

  /* Overloaded function to create a specific enemy */
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