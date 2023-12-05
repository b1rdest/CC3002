package cl.uchile.dcc.citric
package model.board

import cl.uchile.dcc.citric.model.unit.PlayerCharacter

import scala.collection.mutable.ArrayBuffer
import scala.math._

class DropPanel(charactersInput: ArrayBuffer[PlayerCharacter] = ArrayBuffer[PlayerCharacter](),
                nextPanelsInput: ArrayBuffer[Panel] = ArrayBuffer[Panel]())
                extends PanelAbstract(
                  charactersInput,
                  nextPanelsInput){

  def stop(character: PlayerCharacter): Unit = {
    println(character.getName + " has stopped in a Drop Panel! Oh no! ")
    var roll: Int = character.rollDice()
    println(character.getName + " has rolled " + roll.toString)
    character.setStars(0.max(character.getStars - roll*character.getNorma.getLevel))
    println(character.getName + " has lost " + (roll*character.getNorma.getLevel).toString + ", for a total of " + character.getStars.toString)
    this.battlePlayer()
  }
}