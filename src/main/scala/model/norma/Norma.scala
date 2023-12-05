package cl.uchile.dcc.citric
package model.norma

import model.unit.PlayerCharacter

import cl.uchile.dcc.citric.model.game.GameController
import cl.uchile.dcc.citric.model.utility.InputHandler

import scala.collection.mutable.ArrayBuffer


/** Trait for all Norma. The classes differ in the value of their attributes */
trait Norma {

  var inputHandler: InputHandler //Public for testing purposes

  def getLevel(): Int

  def getStarGoal(): Int

  def getWinsGoal(): Int

  def getPlayer(): PlayerCharacter

  def getController(): GameController

  /** Returns a Norma object of the next level if the condition is fulfilled and assigns the new Goal */
  def increase(wins: Int, stars: Int): Norma

  /** Lets the owner player choose their respective goal
   * The goal that was not chosen is set to an impossible value*/
  def updateGoal(): Unit
}
