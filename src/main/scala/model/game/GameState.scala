package cl.uchile.dcc.citric
package model.game
import model.unit.PlayerCharacter
import scala.collection.mutable.ArrayBuffer

trait GameState {
  //def startGame(): Unit
  def rollDice(): Unit
  def doEffect(): Unit
}