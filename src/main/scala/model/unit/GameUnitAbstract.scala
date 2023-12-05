package cl.uchile.dcc.citric
package model.unit

import cl.uchile.dcc.citric.exceptions.AttackDeadUnit

import scala.util.Random

/** Superclass constructor for both PlayerCharacter and WildUnit**/
abstract class GameUnitAbstract (nameInput: String,
                         maxHpInput: Int,
                         ATKInput: Int,
                         DEFInput: Int,
                         EVAInput: Int,
                         RandomInput: Random) extends GameUnit{
  val maxHp: Int = maxHpInput
  var HP: Int = maxHp
  val ATK: Int = ATKInput
  val DEF: Int = DEFInput
  val EVA: Int = EVAInput
  var Alive: Boolean = true
  val name: String = nameInput
  private var Stars: Int = 0
  val randomNumberGenerator: Random = RandomInput
  protected var Wins: Int = 0

  def getName: String = name

  def getHP: Int = HP

  def setHP(newHP: Int): Unit = {
    HP = 0.max(newHP)
  }

  def getAlive: Boolean = Alive

  def setAlive(newAlive: Boolean): Unit = {
    Alive = newAlive
  }

  def getStars: Int = Stars

  def setStars(newStars: Int): Unit = {
    Stars = newStars
  }

  def getWins: Int = Wins

  def setWins(newWins: Int): Unit = {
    Wins = newWins
  }

  /** Abstract method for when the Unit's HP reaches 0. Returns
   * the corresponding amount of Stars when killed in Battle
   * IT IS ONLY CALLED WHEN THE UNIT'S HP REACHES 0. */
  def KO(): Int

  /** Rolls a dice and returns a value between 1 to 6. */
  def rollDice(): Int = {
    randomNumberGenerator.nextInt(6) + 1
  }

  /** Methods for battle */

  /** attack: simply returns the attack of the unit */
  def attack(): Int = {

    if (getAlive) {
      val ataque = this.ATK + this.rollDice()
      println(this.getName.concat(" Rolls ").concat(ataque.toString).concat(" Attack!"))
      ataque
    }
    else {
      0
    }
  }

  /** Methods for defense. Changes the HP given a attack */
  def defend(attackValue: Int): Unit = {
    if (!this.Alive) {
      throw new AttackDeadUnit(this.name.concat(" is dead and cannot defend"))
    }
    else {
      val roll = rollDice()
      println(this.getName.concat(" Rolls ").concat(roll.toString).concat(" Defense!"))
      setHP(0.max(getHP - 1.max(attackValue - (roll + DEF))))
      println(this.getName.concat(" now has ").concat(getHP.toString).concat(" HP!"))
    }
  }

  def evade(attackValue: Int): Unit = {
    if (!this.Alive) {
      throw new AttackDeadUnit(this.name.concat(" is dead and cannot evade"))
    }
    else {
      val roll = rollDice()
      println(this.getName.concat(" Rolls ").concat(roll.toString).concat(" Evasion!"))
      if (EVA + roll > attackValue) {
        setHP(getHP)
      }
      else {
        setHP(0.max(getHP - attackValue))
      }
      println(this.getName.concat(" now has ").concat(getHP.toString).concat(" HP!"))
    }
  }
}