package cl.uchile.dcc.citric
package model

import scala.collection.mutable.ArrayBuffer
import scala.math._

class DropPanel(charactersInput: ArrayBuffer[PlayerCharacter] = ArrayBuffer[PlayerCharacter](),
                nextPanelsInput: ArrayBuffer[PanelTrait] = ArrayBuffer[PanelTrait]())
                extends Panel(
                  "Drop",
                  charactersInput,
                  nextPanelsInput){

  def stop(character: PlayerCharacter): Unit = {
    var roll: Int = character.rollDice()
    character.Stars -= roll*character.getNorma
  }
}