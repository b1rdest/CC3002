package cl.uchile.dcc.citric
package model.norma


/** Trait for all Norma. The classes differ in the value of their attributes */
trait Norma {
  val level: Int
  val starGoal: Int
  val winGoal: Int

  /** Returns a Norma object of the next level if the condition is fulfilled and assigns the new Goal */
  def increase(wins: Int, stars: Int): Norma
}
