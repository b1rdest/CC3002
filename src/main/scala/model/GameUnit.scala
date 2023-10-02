package cl.uchile.dcc.citric
package model

import scala.util.Random

/** The GameUnitTrait defines abstract common variables, values and methods for PlayerCharacter and WildUnit
 *
 */
trait GameUnitTrait {
  protected var HP: Int
  protected var Alive: Boolean
  protected var Stars: Int
  protected var name: String
  protected var maxHp :Int
  protected var attack :Int
  protected var defense :Int
  protected var evasion :Int
  protected var randomNumberGenerator: Random

  /** Abstract method for when the Unit's HP reaches 0. */
  protected def KO(): Unit

  /** Rolls a dice and returns a value between 1 to 6. */
  def rollDice(): Int = {
    randomNumberGenerator.nextInt(6) + 1
  }
}

/** Superclass constructor for both PlayerCharacter and WildUnit**/
abstract class GameUnit (nameInput: String,
                         maxHpInput: Int,
                         ATKInput: Int,
                         DEFInput: Int,
                         EVAInput: Int,
                         RandomInput: Random) extends GameUnitTrait{
  var maxHp: Int = maxHpInput
  var HP: Int = maxHp
  var attack: Int = ATKInput
  var defense: Int = DEFInput
  var evasion: Int = EVAInput
  var Alive: Boolean = true
  var name: String = nameInput
  var Stars: Int = 0
  var randomNumberGenerator: Random = RandomInput
}