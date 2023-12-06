package cl.uchile.dcc.citric
package model.game

import model.unit.PlayerCharacter

//State that also works as an observer for win conditions given by Norma
class WinState(controller: GameController, winner: PlayerCharacter) extends GameState{

  def rollDice(): Unit ={
    //Does nothing
  }
  /** Final state. From here, the only possible action is closing the program */
  def doEffect(): Unit = {
    println(winner.getName + " is the Winner!!!!!")
  }
}
