package cl.uchile.dcc.citric
package model.board

import cl.uchile.dcc.citric.model.unit.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

class NeutralPanel(charactersInput: ArrayBuffer[PlayerCharacter] = ArrayBuffer[PlayerCharacter](),
                   nextPanelsInput: ArrayBuffer[PanelTrait] = ArrayBuffer[PanelTrait]())
                  extends PanelAbstract(
                    "Neutral",
                    charactersInput,
                    nextPanelsInput) {

  def stop(character:PlayerCharacter): Unit = {
    //* Nothing Happens*/
  }
}