package cl.uchile.dcc.citric
package model.board

import cl.uchile.dcc.citric.model.unit.PlayerCharacter
import cl.uchile.dcc.citric.model.game
import cl.uchile.dcc.citric.model.utility.InputHandler
import scala.collection.mutable.ArrayBuffer

class HomePanel (charactersInput: ArrayBuffer[PlayerCharacter] = ArrayBuffer[PlayerCharacter](),
                 nextPanelsInput: ArrayBuffer[Panel] = ArrayBuffer[Panel](),
                 ownerInput: PlayerCharacter)
                extends PanelAbstract(
                      charactersInput,
                      nextPanelsInput) {
    private val owner: PlayerCharacter = ownerInput
    private var inputHandler: InputHandler = new InputHandler

    def getOwner: PlayerCharacter = {
      this.owner
    }

    /* Setter exclusively made for testing ease*/
    def setHandler(newHandler: InputHandler): Unit = {
      this.inputHandler = newHandler
    }


    override def move(character: PlayerCharacter, moves: Int): Panel = {
        if (moves == 0) {
            addCharacter(character)
            stop(character)
            this
        }
        else if (character == this.owner) {
            val decision: String = this.inputHandler.askForInput(ArrayBuffer[String]("Y", "N"),"Do you want to stop on your home panel? [Y]es/[N]o: ")
            if (decision == "Y") {
              move(character, 0)
            }
            else {
              if (nextPanels.size == 1) {
                nextPanels(0).move(character, moves - 1)
              }
              else {
                var index = 0; //* index will be chosen by the player so they can go to the panel they want
                nextPanels(index).move(character, moves - 1)
              }
            }
        }
        else {
          if (nextPanels.size == 1) {
            nextPanels(0).move(character, moves - 1)
          }
          else {
            var index = 0; //* index will be chosen by the player so they can go to the panel they want
            nextPanels(index).move(character, moves - 1)
          }
        }
    }

    def stop(character: PlayerCharacter): Unit = {
      if (character == owner) {
        character.HP += 1
        character.NormaCheck()
      }
    }
}
