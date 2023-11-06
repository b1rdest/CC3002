package cl.uchile.dcc.citric
package model.unit

import scala.util.Random

/** The GameUnitTrait defines abstract common variables, values and methods for PlayerCharacter and WildUnit
 *
 */
trait GameUnit {
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
   * the corresponding amount of Stars when killed in Battle
   * IT IS ONLY CALLED WHEN THE UNIT'S HP REACHES 0.*/
  protected def KO(): Int

  /** Rolls a dice and returns a value between 1 to 6. */
  def rollDice(): Int = {
    randomNumberGenerator.nextInt(6) + 1
  }

  /** Methods for battle */
  /** attack: simply returns the attack of the unit */
  def attack(): Int = {
    if (getAlive) {
      this.ATK+this.rollDice()
    }
    else {
      0
    }
  }
  /** Methods for defense. Changes the HP given a attack */
  def defend(attackvalue: Int): Unit = {
    setHP(0.max(getHP - 1.max(attackvalue - (rollDice() + DEF))))
  }

  def evade(attackvalue: Int): Unit = {
    if (EVA + rollDice() > attackvalue) {
    }
    else {
      setHP(0.max(getHP - attackvalue))
    }
  }
}