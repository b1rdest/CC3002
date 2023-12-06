package cl.uchile.dcc.citric
package model.utility

import model.board._

import cl.uchile.dcc.citric.exceptions.InvalidPanelCreation

import scala.util.Random
/* Creates a random Panel from all the available types
* except HomePanel*/
class RandomPanelFactory extends Factory{
  /* Creates a random panel */
  var random: Random = new Random()

  def create(): Panel = {
    val decision: Int = random.nextInt(4)
    if (decision == 0) { //Creates a Neutral Panel
      create("Neutral")
    }
    else if (decision == 1) { //Creates a Bonus Panel
      create("Bonus")
    }
    else if (decision == 2) { //Creates a Drop Panel
      create("Drop")
    }
    else { //Creates an Encounter Panel
      create("Encounter")
    }
  }

  /* Overloaded function to create a specific panel */
  /* Could eventually be modified to work with a switch case */
  def create(panel: String): Panel = {
    if (panel == "Neutral") { //Creates a Neutral Panel
      new NeutralPanel
    }
    else if (panel == "Bonus") { //Creates a Bonus Panel
      new BonusPanel
    }
    else if (panel == "Drop") { //Creates a Drop Panel
      new DropPanel
    }
    else if (panel == "Encounter") { //Creates an Encounter Panel
      new EncounterPanel
    }
    else {
      throw new InvalidPanelCreation(panel)
    }
  }
}
