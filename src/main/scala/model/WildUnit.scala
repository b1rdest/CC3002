package cl.uchile.dcc.citric
package model

import scala.util.Random


/** Class for Wild Units. Contains all default GameUnit attributes and a constructor for random monsters**/
class WildUnit(nameInput: String,
               maxHpInput: Int,
               ATKInput: Int,
               DEFInput: Int,
               EVAInput: Int,
               RandomInput: Random) extends GameUnit(nameInput,
                      maxHpInput,
                      ATKInput,
                      DEFInput,
                      EVAInput,
                      RandomInput) {
  def KO(): Int = {
    Alive = false
    setStars(0)
    return getStars

    /** Código para borrar la WildUnit cuando muere* */
  }



  /** The constructor with empty parameters creates a random WildUnit**/
  def this() = {
    this("Placeholder", 1, -1, 1, 1, new Random())
    var creature = rollDice()
    if (creature == 1 || creature == 2) {
      this.name = "Chicken"
      this.maxHp = 3
      this.ATK = -1
      this.DEF = -1
      this.EVA = 1
    }
    else if (creature == 3 || creature == 4) {
      this.name = "Robo Ball"
      this.maxHp = 3
      this.ATK= -1
      this.DEF = 1
      this.EVA = -1
    }
    else {
      this.name = "Seagull"
      this.maxHp = 3
      this.ATK = 1
      this.DEF = -1
      this.EVA = -1
    }
  }
}