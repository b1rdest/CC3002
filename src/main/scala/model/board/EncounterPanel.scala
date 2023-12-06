package cl.uchile.dcc.citric
package model.board

import model.unit.PlayerCharacter

import scala.collection.mutable.ArrayBuffer
import model.utility.{EnemyFactory, InputHandler}

import scala.util.Random

/** The "Encounter Panel" Class corresponds to a Panel that triggers a battle between the Player
 *and a random WildUnit when the player stops on it
 * @param charactersInput The PlayerCharacters that are initially on the Panel. Can be empty.
 * @param nextPanelsInput The Panels that follow this Panel. Can not be empty.
 */

class EncounterPanel(charactersInput: ArrayBuffer[PlayerCharacter] = ArrayBuffer[PlayerCharacter](),
                     nextPanelsInput: ArrayBuffer[Panel] = ArrayBuffer[Panel]())
                    extends PanelAbstract(
                      charactersInput,
                      nextPanelsInput) {

  /**If the Player stops on an encounter Panel, it triggers
   * a battle between the Player and a randomly generated Wild Unit.
   *
   * @param character The Player that stops on this Panel. Calls to it's Battle() method.
   */

  val inputHandler: InputHandler = new InputHandler
  def stop(character: PlayerCharacter): Unit = {
    val factory = new EnemyFactory
    val enemy = factory.create()
    println(character.getName + " has stopped in an Encounter Panel! Prepare for Battle! ")


    //The battle between the player and the random monster begins
    println("Player ".concat(character.getName).concat(" is fightintg a wild ").concat(enemy.getName))

    while (character.getAlive & enemy.getAlive) {
      val random = new Random()
      if (random.nextInt(1) == 0) { //the enemy creature defends
        enemy.defend(character.attack())
      }
      else {
        enemy.evade(character.attack())
      }
      if (enemy.getHP == 0) {
        println(enemy.getName.concat(" has fainted! "))
        character.setWins(character.getWins + 1)
        character.setStars(character.getStars + enemy.KO())
        println(character.getName.concat(" now has ").concat(character.getStars.toString).concat(" stars."))
      }
      else {
        val decision = inputHandler.askForInput(ArrayBuffer[String]("DEF", "EVA"), "Choose " +
          "how you're gonna receive the attack! [DEF]/[EVA]")
        if (decision == "DEF" | decision == "def") {
          character.defend(enemy.attack())
        }
        else {
          character.evade(enemy.attack())
        }
      }
      if (character.getHP == 0) {
        println(character.getName.concat(" has fainted! "))
        enemy.setStars(enemy.getStars + character.KO())
      }
    }
    this.battlePlayer()
  }
}
