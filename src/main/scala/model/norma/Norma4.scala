package cl.uchile.dcc.citric
package model.norma

class Norma4 extends Norma{
  val level = 4
  val starGoal: Int = 70
  val winGoal: Int = 6

  def increase(wins: Int, stars: Int): Norma = {
    if (wins >= winGoal || stars >= starGoal) { //* Will be replaced by the condition chosen by the player to acquire Norma */
      new Norma5()
    }
    else { //* If the condition doesnt succeed, it will simply return itself
      this
    }
  }
}
