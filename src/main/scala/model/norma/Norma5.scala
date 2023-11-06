package cl.uchile.dcc.citric
package model.norma

class Norma5 extends Norma{
  val level = 5
  val starGoal: Int = 120
  val winGoal: Int = 10

  def increase(wins: Int, stars: Int): Norma = {
    if (wins >= winGoal || stars >= starGoal) { //* Will be replaced by the condition chosen by the player to acquire Norma */
      new Norma6()
    }
    else { //* If the condition doesnt succeed, it will simply return itself
      this
    }
  }
}
