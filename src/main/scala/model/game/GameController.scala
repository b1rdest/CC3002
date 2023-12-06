package cl.uchile.dcc.citric
package model.game
import model.unit.PlayerCharacter

import cl.uchile.dcc.citric.model.board._
import cl.uchile.dcc.citric.model.utility.InputHandler

import scala.collection.mutable._
import scala.collection.mutable.ArrayBuffer

class GameController {
 //Jugadores
  var players: ArrayBuffer[PlayerCharacter] = ArrayBuffer[PlayerCharacter]()
  // Estado actual del juego
  var state: GameState = new GameEnd(this)
  var chapters: Int = 0
  var turnOrder: Queue[PlayerCharacter] = Queue[PlayerCharacter]()
  var currentPanel: Panel = new NeutralPanel() //Placeholder



  //def startGame(): Unit = {
  //  state.startGame()
    /* ... */
  //}

  /** Return the player whose' turn is next */
  def nextTurnPlayer(): PlayerCharacter = {
    val nextPlayer = this.turnOrder.dequeue()
    this.turnOrder.enqueue(nextPlayer)
    nextPlayer
  }


  def rollDice(): Unit = {
    state.rollDice()
  }

  def doEffect(): Unit = {
    val input = new InputHandler
    var continue = input.askForInput("Press Enter to continue, or [Q] to exit")
    while(continue != "Q") {
      state.doEffect()
      continue = input.askForInput("Press Enter to continue, or [Q] to exit")
    }
  }

  def changeState(state:GameState): Unit = { //setter
    this.state = state
  }

  def updateWinner(player: PlayerCharacter): Unit = {
    this.state = new WinState(this, player)
  }

}