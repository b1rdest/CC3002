package cl.uchile.dcc.citric
package model

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
trait PanelTrait {

  val panelType: String

  /** Array of the characters currently positioned on this panel.
    *
    * In the game, multiple characters might be on the same panel at once, e.g., if multiple players
    * land on the same space.
    */
  val characters: ArrayBuffer[PlayerCharacter]

  /** An array of panels that are directly connected to this one.
   *
   * In the context of the game, multiple routes or paths may exist, this could represent the
   * possible next steps a player might take after being on this panel.
   *
   * @return a List of Panel instances that are adjacent or connected to this panel.
   */
  var nextPanels: ArrayBuffer[PanelTrait]

  /** Adds a character to the list of characters currently on this panel.
    *
    * This might be invoked when a player moves to this panel or starts their turn on it.
    *
    * @param player The player character to add to this panel.
    */
  protected def addCharacter(player: PlayerCharacter): Unit

  /** Removes a character from the list of characters currently on this panel.
    *
    * This might be invoked when a player moves off this panel.
    *
    * @param player The player character to remove from this panel.
    */
  protected def removeCharacter(player: PlayerCharacter): Unit

  def move(character: PlayerCharacter, moves: Int): Unit

  protected def stop(character: PlayerCharacter): Unit
}


/** Implements methods common for all panels**/
abstract class Panel(panelTypeInput: String,
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

