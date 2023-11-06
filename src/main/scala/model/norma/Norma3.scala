package cl.uchile.dcc.citric
package model.norma

class Norma3 extends Norma{
  val level = 3
  val starGoal: Int = 30
  val winGoal: Int = 3

  def increase(wins: Int, stars: Int): Norma = {
    if (wins >= winGoal || stars >= starGoal) { //* Will be replaced by the condition chosen by the player to acquire Norma */
      new Norma4()
    }
    else { //* If the condition doesnt succeed, it will simply return itself
      this
    }
  }
}
