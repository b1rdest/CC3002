package cl.uchile.dcc.citric
package model.norma

class Norma6 extends Norma{
  val level = 6
  val starGoal: Int = 200
  val winGoal: Int = 14

  def increase(wins: Int, stars: Int): Norma = {
    if (wins >= winGoal || stars >= starGoal) { //*
      this // At this point, the player wins, functionality will be added later.
    }
    else {
      this
    }
  }
}
