package cl.uchile.dcc.citric
package model

import scala.collection.mutable.ArrayBuffer
import scala.math._

class BonusPanel(charactersInput: ArrayBuffer[PlayerCharacter],
                  nextPanelsInput: ArrayBuffer[PanelTrait])
                extends Panel(
                  "Bonus",
                  charactersInput,
                  nextPanelsInput) {

  def stop(character: PlayerCharacter): Unit = {
    var roll: Int = character.rollDice()
    character.Stars += min(roll*character.Norma, roll*3)
  }
}
