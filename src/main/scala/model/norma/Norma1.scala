package cl.uchile.dcc.citric
package model.norma

class Norma1 extends Norma{
  val level = 1
  val starGoal: Int = 0
  val winGoal: Int = 0

  def increase(wins: Int, stars: Int): Norma = {
    if (wins >= winGoal || stars >= starGoal) { //*Will be replaced by the condition chosen by the player to acquire Norma */
      new Norma2()
    }
    else { //* If the condition doesnt succeed, it will simply return itself
      this
    }
  }
}
