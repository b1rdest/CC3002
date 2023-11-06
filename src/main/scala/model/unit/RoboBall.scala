package cl.uchile.dcc.citric
package model.unit

import scala.util.Random

class RoboBall (name:String = "Robo Ball",
               maxHp:Int = 3,
               ATK:Int = -1,
               DEF:Int = 1,
               EVA:Int = -1, Random: Random = new Random()
              ) extends WildUnitAbstract(name, maxHp, ATK, DEF, EVA, Random) {

  override def KO(): Int = {
    Alive = false
    getStars + 2

    /** Código para borrar la WildUnit cuando muere* */
  }
}

