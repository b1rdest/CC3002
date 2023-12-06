package cl.uchile.dcc.citric
package model.norma

import model.unit.PlayerCharacter
import model.utility.InputHandler

import model.game.GameController

import scala.collection.mutable.ArrayBuffer

abstract class NormaAbstract extends Norma{
  val level: Int
  var starGoal: Int
  var winGoal: Int
  val player: PlayerCharacter
  val controller: GameController
  var inputHandler: InputHandler

  def getLevel():Int = this.level

  def getStarGoal(): Int = this.starGoal

  def getWinsGoal(): Int = this.winGoal

  def getPlayer(): PlayerCharacter = this.player

  def getController(): GameController = this.controller

  def updateGoal(): Unit = {
    val goal = inputHandler.askForInput(ArrayBuffer[String]("s", "w"), this.player.getName + ", please choose your Norma Condition [s]tars/[w]ins:")
    if (goal == "s") {
      winGoal = 999
    }
    else {
      starGoal = 999
    }
  }
}
