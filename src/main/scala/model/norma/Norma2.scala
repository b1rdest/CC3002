package cl.uchile.dcc.citric
package model.norma

class Norma2 extends Norma{
  val level = 2
  val starGoal: Int = 10
  val winGoal: Int = 1

  def increase(wins: Int, stars: Int): Norma = {
    if (wins >= winGoal || stars >= starGoal) { //* Will be replaced by the condition chosen by the player to acquire Norma */
      new Norma3()
    }
    else { //* If the condition doesnt succeed, it will simply return itself
      this
    }
  }
}
