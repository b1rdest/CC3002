package cl.uchile.dcc.citric
package model.board

import cl.uchile.dcc.citric.model.unit.PlayerCharacter

import scala.collection.mutable.ArrayBuffer
import scala.math._

class BonusPanel(charactersInput: ArrayBuffer[PlayerCharacter] = ArrayBuffer[PlayerCharacter](),
                 nextPanelsInput: ArrayBuffer[PanelTrait] = ArrayBuffer[PanelTrait]())
                extends PanelAbstract(
                  "Bonus",
                  charactersInput,
                  nextPanelsInput) {

  def stop(character: PlayerCharacter): Unit = {
    val roll: Int = character.rollDice()
    character.setStars(character.getStars + min(roll*character.getNorma.level, roll*3))
  }
}
