package cl.uchile.dcc.citric
package model.board

import cl.uchile.dcc.citric.model.unit.PlayerCharacter

import scala.collection.mutable.ArrayBuffer
import scala.math._

class DropPanel(charactersInput: ArrayBuffer[PlayerCharacter] = ArrayBuffer[PlayerCharacter](),
                nextPanelsInput: ArrayBuffer[PanelTrait] = ArrayBuffer[PanelTrait]())
                extends PanelAbstract(
                  "Drop",
                  charactersInput,
                  nextPanelsInput){

  def stop(character: PlayerCharacter): Unit = {
    var roll: Int = character.rollDice()
    character.setStars(character.getStars - roll*character.getNorma.level)
  }
}