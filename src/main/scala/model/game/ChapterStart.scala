package cl.uchile.dcc.citric
package model.game

class ChapterStart(controller: GameController) extends GameState {
  def rollDice():Unit = {

  }

  def doEffect(): Unit = {
    if (controller.chapters > 99) { //Chapters is only a counter
      println("game end")
      controller.changeState(new GameEnd(controller))
    }
    else {
      println("A new Chapter Starts!")
      controller.changeState(new PlayerTurn(controller))
    }
  }
}
