package cl.uchile.dcc.citric
package model.board

import cl.uchile.dcc.citric.model.unit.PlayerCharacter

import scala.collection.mutable.ArrayBuffer
import scala.math._

class BonusPanel(charactersInput: ArrayBuffer[PlayerCharacter] = ArrayBuffer[PlayerCharacter](),
                 nextPanelsInput: ArrayBuffer[Panel] = ArrayBuffer[Panel]())
                extends PanelAbstract(
                  charactersInput,
                  nextPanelsInput) {

  def stop(character: PlayerCharacter): Unit = {
    println(character.getName + " has stopped in a Bonus Panel! Lucky Day! ")
    val roll: Int = character.rollDice()
    println(character.getName + " has rolled " + roll.toString)
    character.setStars(character.getStars + min(roll*character.getNorma.getLevel, roll*3))
    println(character.getName + " has obtained " + min(roll*character.getNorma.getLevel, roll*3).toString + " stars, for a total of " + character.getStars.toString)
    this.battlePlayer()
  }
}
