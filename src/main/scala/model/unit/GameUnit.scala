package cl.uchile.dcc.citric
package model.unit

import cl.uchile.dcc.citric.exceptions.AttackDeadUnit

import scala.util.Random

/** The GameUnitTrait defines abstract common variables, values and methods for PlayerCharacter and WildUnit
 *
 */
trait GameUnit {

  def getName: String

  def getHP: Int

  def getAlive: Boolean

  def getStars: Int

  def getWins: Int

  def setStars(newStars:Int): Unit

  def rollDice(): Int

  def attack(): Int

  def defend(attackValue: Int): Unit

  def evade(attackValue: Int): Unit

  def KO():Int
}