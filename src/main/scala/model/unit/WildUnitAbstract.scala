package cl.uchile.dcc.citric
package model.unit

import scala.util.Random


/** Class for Wild Units. Contains all default GameUnit attributes and a constructor for random monsters**/
abstract class WildUnitAbstract(nameInput: String,
               maxHpInput: Int,
               ATKInput: Int,
               DEFInput: Int,
               EVAInput: Int,
               RandomInput: Random) extends GameUnitAbstract(nameInput,
                      maxHpInput,
                      ATKInput,
                      DEFInput,
                      EVAInput,
                      RandomInput) {

  //* Código base para cualquier Wild Unit*/
  def KO(): Int = {
    Alive = false
    setStars(0)
    getStars

    /** Código para borrar la WildUnit cuando muere* */
  }
}