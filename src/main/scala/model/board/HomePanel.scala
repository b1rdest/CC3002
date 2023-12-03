package cl.uchile.dcc.citric
package model.board

import cl.uchile.dcc.citric.model.unit.PlayerCharacter

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn.readLine

class HomePanel (charactersInput: ArrayBuffer[PlayerCharacter] = ArrayBuffer[PlayerCharacter](),
                 nextPanelsInput: ArrayBuffer[Panel] = ArrayBuffer[Panel](),
                 ownerInput: PlayerCharacter)
                extends PanelAbstract(
                      charactersInput,
                      nextPanelsInput) {
    private val owner: PlayerCharacter = ownerInput

    def getOwner():PlayerCharacter ={
      this.owner
    }

    def move(character: PlayerCharacter, moves: Int): Panel = {
        if (moves == 0) {
            addCharacter(character)
            stop(character)
            this
        }
        else if (character == owner) {
            //var stops = readLine("Stop in your Home Panel? [Y]es or [N]o: ")//
            val decision: String = "Y"
            if (decision == "Y") {
                move(character, 0)
            }
        }
        else {
            move(character, moves - 1)
        }
    }

    def stop(character: PlayerCharacter): Unit = {
      if (character == owner) {
        character.HP += 1
        character.NormaCheck()
      }
    }
}
