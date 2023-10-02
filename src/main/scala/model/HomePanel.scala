package cl.uchile.dcc.citric
package model

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn.readLine

class HomePanel (charactersInput: ArrayBuffer[PlayerCharacter] = ArrayBuffer[PlayerCharacter](),
                 nextPanelsInput: ArrayBuffer[PanelTrait] = ArrayBuffer[PanelTrait](),
                 ownerInput: PlayerCharacter)
                extends Panel(
                      "Home",
                      charactersInput,
                      nextPanelsInput) {
    private val owner: PlayerCharacter = ownerInput

    def move(character: PlayerCharacter, moves: Int, decision: String): Unit = {
        if (moves == 0) {
            addCharacter(character)
            stop(character)
        }
        else if (character == owner) {
            //var stops = readLine("Stop in your Home Panel? [Y]es or [N]o: ")//

            if (decision == "Y") {
                move(character, 0)
            }
        }
        else {
            move(character, moves - 1)
        }
    }

    def stop(character: PlayerCharacter): Unit = {
        character.HP += 1
        character.NormaCheck()
    }
}
