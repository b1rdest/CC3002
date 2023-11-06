package cl.uchile.dcc.citric
package model.board

import cl.uchile.dcc.citric.model.unit.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

class NeutralPanel(charactersInput: ArrayBuffer[PlayerCharacter] = ArrayBuffer[PlayerCharacter](),
                   nextPanelsInput: ArrayBuffer[Panel] = ArrayBuffer[Panel]())
                  extends PanelAbstract(
                    charactersInput,
                    nextPanelsInput) {

  def stop(character:PlayerCharacter): Unit = {
    //* Nothing Happens*/
  }
}