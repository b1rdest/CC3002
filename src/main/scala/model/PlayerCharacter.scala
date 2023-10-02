package cl.uchile.dcc.citric
package model

import scala.util.Random
import scala.io.StdIn.readLine
import scala.util.control.Breaks._

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
  * @param attack The player's capability to deal damage to opponents.
  * @param defense The player's capability to resist or mitigate damage from opponents.
  * @param evasion The player's skill to completely avoid certain attacks.
  * @param randomNumberGenerator A utility to generate random numbers. Defaults to a new `Random`
  *                              instance.
  * @param Wins Amount of victories accumulated by the player by through fighting against other Players or Wild Units.
  * @param Norma Amount of Norma Points accumulated by the player. The player wins when they achieve 6 Norma points
  * @param NormaCondition Condition chosen by the players each time they level up. If fulfilled, they achieve one
  *                       Norma point and are allowed to choose another condition.
  * @param StarsCondition Necessary number of stars to achieve obtain one Norma point
  * @param WinsCondition Necessary number of wins to achieve obtain one Norma point
 *
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
              extends GameUnit(nameInput,
                      maxHPInput,
                      ATKInput,
                      DEFInput,
                      EVAInput,
                      RandomInput) {
  private var Wins: Int = 0
  private var Norma: Int = 1
  private var NormaCondition: String =  ""
  private var StarsCondition: Int = 10
  private var WinsCondition: Int = 1

  def getNorma: Int = Norma

  def setNorma(newNorma: Int): Unit = {
    Norma = newNorma
  }

  /** The function KO() switches the Alive variable to false if it is initially true, putting the player into Recovery mode.
   *  If Alive is false (Recovery mode), it rolls a Dice and will only switch it to true if the requirements are fulfilled.
   **/
  def KO(): Unit = {
    if (Alive) {
      Alive = false
    }
    else {
      /** We assume that variable Chapters is public within the package and give it a placeholder value */
      var Chapters = 1
      if (rollDice() >= 6 - Chapters) {
        Alive = true
      }
    }
  }

  /**Triggers a battle between the Player and a Unit
   * @param enemy The enemy that the PlayerCharacter will fight. Has to be a GameUnit (PlayerCharacter or WildUnit).
   */
  private[model] def Battle(enemy: GameUnitTrait): Unit = {
    //** Código de pelea entre PlayerCharacter y PlayerCharacter/WildUnit**//
  }

  /**Triggered when NormaCheck() succeeds. Increases the player's Norma points by one,
   * updates both Stars and Wins conditions, and lets the player choose a new Norma
   * condition.
   *
   */
  private def NormaClear(): Unit = {
    Norma += 1
    Norma match {
      case 2 => {
        StarsCondition = 30
        WinsCondition = 3
      }
      case 3 => {
        StarsCondition = 70
        WinsCondition = 6
      }
      case 4 => {
        StarsCondition = 120
        WinsCondition = 10
      }
      case 5 => {
        StarsCondition = 200
        WinsCondition = 14
      }
    }
    breakable { while (true) {
      NormaCondition = readLine("Enter new Norma Condition ([S] for Stars or [W] for Wins): ")
      if (NormaCondition == "S" || NormaCondition == "W") {
        break
      }
    } }
  }

  /** Triggered when the player stops on a Home Panel. Checks if they fulfill
   * the necessary conditions to obtain one Norma Point according to the condition
   * they chose. If successful, calls for NormClear().
   */
  private[model] def NormaCheck(): Unit = {
    if (NormaCondition == "S") {
      if (Stars >= StarsCondition)
        NormaClear()
    }
    if (NormaCondition == "W"){
      if (Wins >= WinsCondition) {
        NormaClear()
      }
    }
  }
}
