package cl.uchile.dcc.citric
package model

import scala.collection.mutable.ArrayBuffer
import scala.math._

class BonusPanel(charactersInput: ArrayBuffer[PlayerCharacter] = ArrayBuffer[PlayerCharacter](),
                 nextPanelsInput: ArrayBuffer[PanelTrait] = ArrayBuffer[PanelTrait]())
                extends Panel(
                  "Bonus",
                  charactersInput,
                  nextPanelsInput) {

  def stop(character: PlayerCharacter): Unit = {
    val roll: Int = character.rollDice()
    character.Stars += min(roll*character.getNorma, roll*3)
  }
}
