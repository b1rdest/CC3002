package cl.uchile.dcc.citric
package model.unit

import scala.util.Random
import model.norma.{Norma, Norma1}

import cl.uchile.dcc.citric.model.board

/** The `PlayerCharacter` class represents a character or avatar in the game, encapsulating
  * several attributes such as health points, attack strength, defense capability,
  * and evasion skills. Each player has a unique name, and throughout the game,
  * players can collect stars, roll dice, and progress in levels known as 'norma'.
  * This class not only maintains the state of a player but also provides methods
  * to modify and interact with these attributes.
  *
  * For instance, players can:
 *
  * - Increase or decrease their star count.
 *
  * - Roll a dice, a common action in many board games.
 *
  * - Advance their norma level.
  *
  * Furthermore, the `Player` class has a utility for generating random numbers,
  * which is primarily used for simulating dice rolls. By default, this utility is
  * an instance of the `Random` class but can be replaced if different random
  * generation behaviors are desired.
  *
  * @param name The name of the player. This is an identifier and should be unique.
  * @param maxHp The maximum health points a player can have. It represents the player's endurance.
  * @param ATK The player's capability to deal damage to opponents.
  * @param DEF The player's capability to resist or mitigate damage from opponents.
  * @param EVA The player's skill to completely avoid certain attacks.
  * @param randomNumberGenerator A utility to generate random numbers. Defaults to a new `Random`
  *                              instance.
  * @param Wins Amount of victories accumulated by the player by through fighting against other Players or Wild Units.
  * @param Norma Amount of Norma Points accumulated by the player. The player wins when they achieve 6 Norma points
  * @author [[https://github.com/danielRamirezL/ Daniel Ramírez L.]]
  * @author [[https://github.com/joelriquelme/ Joel Riquelme P.]]
  * @author [[https://github.com/r8vnhill/ Ignacio Slater M.]]
  * @author [[https://github.com/Seivier/ Vicente González B.]]
  * @author [[https://github.com/b1rdest/ Diego Vergara V.]]
  */
class PlayerCharacter(nameInput: String,
              maxHPInput: Int,
              ATKInput: Int,
              DEFInput: Int,
              EVAInput: Int,
              RandomInput: Random = new Random())
              extends GameUnitAbstract(nameInput,
                      maxHPInput,
                      ATKInput,
                      DEFInput,
                      EVAInput,
                      RandomInput) {
  private var normaLevel: Norma = new Norma1()

  def getNorma: Norma = {
    this.normaLevel
  }

  def setNorma(newNorma: Norma): Unit = {
    this.normaLevel = newNorma
  }

  /** The function KO() switches the Alive variable to false if it is initially true, putting the player into Recovery mode.
   *  and returns the corresponding amount of stars.
   *  If Alive is false (Recovery mode), it rolls a Dice and will only switch it to true if the requirements are fulfilled.
   **/
  def KO(): Int = {
    if (Alive) { //
      Alive = false
      setStars(getStars/2)
      getStars
    }
    else {
      /** We assume that variable Chapters is public within the package and give it a placeholder value */
      var Chapters = 1
      if (rollDice() >= 6 - Chapters) {
        Alive = true
        0
      }
      else {
        0
      }
    }
  }

  /**Triggers a battle between the Player and a Unit
   * @param enemy The enemy that the PlayerCharacter will fight. Has to be a GameUnit (PlayerCharacter or WildUnit).
   */
  def Battle(enemy: GameUnit): Unit = {
    //** Código de pelea entre PlayerCharacter y PlayerCharacter/WildUnit**//
  }

  /** Triggered when the player stops on a Home Panel. Checks if they fulfill
   * the necessary conditions to obtain one Norma Point according to the condition
   * they chose. If successful, calls for increase() from the class Norma.
   */
  def NormaCheck(): Unit = {
    normaLevel = this.normaLevel.increase(getStars, getWins)
  }


  //* Function that is called when a unit is defeated
  // General case for game Unit, only 1 win is obtained*/
  def receiveWins(unit: GameUnit): Unit = {
    this.setWins(this.getWins + 1)
  }

  //*Overloaded function of receiveWins. If the defeated unit is a Player, then 2 wins are achieved*/
  def receiveWins(unit: PlayerCharacter): Unit = {
    this.setWins(this.getWins + 2)
  }
}
