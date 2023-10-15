package cl.uchile.dcc.citric
package model

import scala.util.Random

/** The GameUnitTrait defines abstract common variables, values and methods for PlayerCharacter and WildUnit
 *
 */
trait GameUnitTrait {
  protected var HP: Int
  def getHP: Int = HP
  def setHP(newHP: Int): Unit = {
    HP = newHP
  }

  protected var Alive: Boolean
  def getAlive: Boolean = Alive
  def setAlive(newAlive: Boolean): Unit = {
    Alive = newAlive
  }

  protected var Stars: Int
  def getStars: Int = Stars
  def setStars(newStars: Int): Unit = {
    Stars = newStars
  }
  protected var Wins: Int = 0
  def getWins: Int = Wins
  def setWins(newWins: Int): Unit = {
    Wins = newWins
  }

  protected var name: String
  protected var maxHp: Int
  protected var ATK: Int
  protected var DEF: Int
  protected var EVA: Int
  protected var randomNumberGenerator: Random

  /** Abstract method for when the Unit's HP reaches 0. Returns
   * the corresponding amount of Stars when killed in Battle */
  protected def KO(): Int

  /** Rolls a dice and returns a value between 1 to 6. */
  def rollDice(): Int = {
    randomNumberGenerator.nextInt(6) + 1
  }

  /** Methods for battle */
  def attack(defender: GameUnitTrait, method: Int => Int): Unit = {
    if (defender.Alive && getAlive) {
      setStars(getStars + method(rollDice() + ATK))
      if (!defender.getAlive) {
        if (defender.getClass == PlayerCharacter) {
          setWins(getWins + 1)
        }
        setWins(getWins + 1)
      }
    }
  }
  /** Methods for defense. Return the Stars of the defendingUnit */
  def defend(attackvalue: Int): Int = {
    setHP(0.max(getHP - 1.max(attackvalue - (rollDice() + DEF))))

    /** This part of the code is repeated. It is optimizable. */
    if (getHP == 0) {
      setAlive(false)
      return KO()
    }
    else {
      0
    }
  }

  def evade(attackvalue: Int): Int = {
    if (EVA + rollDice() > attackvalue) {
    }
    else {
      setHP(0.max(getHP - attackvalue))
    }
    if (getHP == 0){
      setAlive(false)
      return KO()
    }
    else {
      return 0
    }
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
  var ATK: Int = ATKInput
  var DEF: Int = DEFInput
  var EVA: Int = EVAInput
  var Alive: Boolean = true
  var name: String = nameInput
  var Stars: Int = 0
  var randomNumberGenerator: Random = RandomInput
}