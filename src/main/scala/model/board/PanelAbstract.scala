package cl.uchile.dcc.citric
package model.board

import cl.uchile.dcc.citric.model.unit.PlayerCharacter

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn.readLine

/** Represents a single cell on a board, known as a Panel.
  *
  * Each panel has its own effect, which can be applied to a character.
  * In the context of the board game, a panel represents a tile or space that a character lands on
  * and experiences an effect (e.g., losing stars, fighting an enemy, etc.).
  * Panels can also be connected to other panels, allowing for the formation of complex board
  * structures.
  *
  * @author [[https://github.com/r8vnhill Ignacio Slater M.]]
  * @author [[https://github.com/b1rdest Diego Vergara V.]]
  */

/** Implements methods common for all panels**/
abstract class PanelAbstract(panelTypeInput: String,
                     charactersInput: ArrayBuffer[PlayerCharacter]  = ArrayBuffer[PlayerCharacter](),
                     nextPanelsInput: ArrayBuffer[PanelTrait] = ArrayBuffer[PanelTrait]())
  extends PanelTrait {
  val panelType: String = panelTypeInput
  val characters: ArrayBuffer[PlayerCharacter]= charactersInput
  var nextPanels: ArrayBuffer[PanelTrait] = nextPanelsInput

  def addCharacter(character: PlayerCharacter): Unit = {
    characters += character
  }

  def removeCharacter(character: PlayerCharacter):Unit = {
    characters -= character
  }

    /**Allows you to move between Panels recursively.If no more moves are allowed, the it calls for the
     * stop() method and adds the character to characters
     **/
  def move(character: PlayerCharacter, moves: Int): Unit = {
    if (moves == 0) {
      addCharacter(character)
      stop(character)
    }
    else {
      if (nextPanels.size == 1) {
        nextPanels(0).move(character, moves - 1)
      }
      else {
        var index:Int = readLine("Enter which Panel you want to go to: ").toInt
        nextPanels(index).move(character, moves - 1)
      }
    }
  }
  def stop(character:PlayerCharacter):Unit
}

