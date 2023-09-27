package cl.uchile.dcc.citric
package model

import scala.collection.mutable.ArrayBuffer

class NeutralPanel(charactersInput: ArrayBuffer[PlayerCharacter],
                   nextPanelsInput: ArrayBuffer[PanelTrait])
                  extends Panel(
                    "Neutral",
                    charactersInput,
                    nextPanelsInput) {

  def stop(character:PlayerCharacter): Unit = {
    println("Nothing happens")
  }
}