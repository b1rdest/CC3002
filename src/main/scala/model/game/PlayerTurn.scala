package cl.uchile.dcc.citric
package model.game

import model.unit.PlayerCharacter

import model.utility.InputHandler

class PlayerTurn(controller: GameController) extends GameState {
  private var nowPlayer = new PlayerCharacter("bob",0,0,0,0, controllerInput = new GameController) //temporary value
  //def startGame(): Unit = {
  val inputHandler = new InputHandler


  //}

  def rollDice(): Unit = {
    //pending
    inputHandler.askForInput("> It is ".concat(nowPlayer.getName).concat("'s turn, press any button to throw the dice"))
    val roll = nowPlayer.rollDice()
    println(nowPlayer.getName.concat(" has rolled ").concat(roll.toString))
    nowPlayer.currentPanel.move(nowPlayer, roll) //al final de move se llama a stop, el cual triggerea el efecto del panel
    controller.changeState(new PlayerTurn(controller))
  }

  def doEffect(): Unit = { 
    nowPlayer = controller.turnOrder.dequeue()
    controller.turnOrder.enqueue(nowPlayer)
    nowPlayer.setStars(nowPlayer.getStars + controller.chapters/5 + 1)
    println(nowPlayer.getName + " has received " + (controller.chapters/5 + 1).toString + " stars, for a total of " + nowPlayer.getStars.toString)
    if (nowPlayer.Alive) {
      this.rollDice()
    }
    else {
      nowPlayer.KO() //Recovery Phase
      controller.changeState(new PlayerTurn(controller))
    }

  }
}
