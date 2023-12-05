package cl.uchile.dcc.citric
package model.board

import model.unit.PlayerCharacter

import model.utility.InputHandler

import scala.collection.mutable.ArrayBuffer

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
abstract class PanelAbstract(
                     charactersInput: ArrayBuffer[PlayerCharacter]  = ArrayBuffer[PlayerCharacter](),
                     nextPanelsInput: ArrayBuffer[Panel] = ArrayBuffer[Panel]())
  extends Panel {
  val characters: ArrayBuffer[PlayerCharacter] = charactersInput
  var nextPanels: ArrayBuffer[Panel] = nextPanelsInput

  def addCharacter(character: PlayerCharacter): Unit = {
    characters += character
  }

  def removeCharacter(character: PlayerCharacter):Unit = {
    characters -= character
  }

    /**Allows you to move between Panels recursively.If no more moves are allowed, the it calls for the
     * stop() method and adds the character to characters
     **/
  def move(character: PlayerCharacter, moves: Int): Panel = {
    if (this.characters.contains(character)) {
      this.removeCharacter(character)
    }
    if (moves == 0) {
      addCharacter(character)
      character.setPanel(this)
      stop(character)
      this
    }
    else {
      if (nextPanels.size == 1) {
        nextPanels(0).move(character, moves - 1)
      }
      else {
        val index = 0; //* index will be chosen by the player so they can go to the panel they want
        nextPanels(index).move(character, moves - 1)
      }
    }
  }
  def stop(character:PlayerCharacter):Unit

  def battlePlayer(): Unit = {
    if (characters.length > 1) {
      var fighter1 = this.characters(this.characters.length-1)
      val inputHandler = new InputHandler
      println("In this Panel, there's the following players:")
      for (i <- Range.inclusive(0, this.characters.length-1)) {
        println(this.characters(i).getName.concat(" [").concat(i.toString).concat("]"))
      }
      val fighter2Index = inputHandler.askForInput("" +  fighter1.getName.concat(", please choose which player you want to fight: (Press any other button if you do not want to fight anyone)"))
      if (Range.inclusive(0, this.characters.length-2).contains(fighter2Index.toInt)) {
        var fighter2 = this.characters(fighter2Index.toInt)
        while (fighter1.getAlive & fighter2.getAlive) {
          println(fighter1.getName + " is attacking!")
          println(fighter2.getName + " is being attacked!")
          val decision = inputHandler.askForInput(ArrayBuffer[String]("DEF", "EVA"), fighter2.getName + " Choose " +
            "how you're gonna receive the attack! [DEF]/[EVA]")
          if (decision == "DEF" | decision == "def") {
            fighter2.defend(fighter1.attack())
          }
          else {
            fighter2.evade(fighter1.attack())
          }
          if (fighter2.getHP == 0) {
            println(fighter2.getName.concat(" has fainted! "))
            fighter1.setWins(fighter1.getWins + 1)
            fighter1.setStars(fighter1.getStars + fighter2.KO())
            println(fighter1.getName.concat(" now has ").concat(fighter1.getStars.toString).concat(" stars."))
          }
          else { //Attacker and Defender are swapped
            val fighterTemp = fighter1
            fighter1 = fighter2
            fighter2 = fighterTemp
          }
        }
      }

    }
  }

  def addPanel(panel: Panel):Unit = {
    this.nextPanels += panel
  }

  def addPanelatEnd(panel: Panel):Unit = {
    if (this.nextPanels.isEmpty) {
      this.addPanel(panel)
    }
    else {
      this.nextPanels(0).addPanelatEnd(panel)
    }
  }
}

