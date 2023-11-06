package cl.uchile.dcc.citric
package model.unit

import scala.util.Random

/** Superclass constructor for both PlayerCharacter and WildUnit**/
abstract class GameUnitAbstract (nameInput: String,
                         maxHpInput: Int,
                         ATKInput: Int,
                         DEFInput: Int,
                         EVAInput: Int,
                         RandomInput: Random) extends GameUnit{
  var maxHp: Int = maxHpInput
  var HP: Int = maxHp
  var ATK: Int = ATKInput
  var DEF: Int = DEFInput
  var EVA: Int = EVAInput
  var Alive: Boolean = true
  var name: String = nameInput
  var Stars: Int = 0
  var randomNumberGenerator: Random = RandomInput
}