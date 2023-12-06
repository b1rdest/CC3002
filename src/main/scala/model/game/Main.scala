package cl.uchile.dcc.citric
package model.game

/* El programa main ejecuta el juego!*/
object Main {
  def main(args: Array[String]) = {
    val game = new GameController
    game.state = new StartState(game)
    game.doEffect()
  }
}
