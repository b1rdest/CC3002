package cl.uchile.dcc.citric
package model.board

import cl.uchile.dcc.citric.model.unit.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

/** The "Encounter Panel" Class corresponds to a Panel that triggers a battle between the Player
 *and a random WildUnit when the player stops on it
 * @param charactersInput The PlayerCharacters that are initially on the Panel. Can be empty.
 * @param nextPanelsInput The Panels that follow this Panel. Can not be empty.
 */

class EncounterPanel(charactersInput: ArrayBuffer[PlayerCharacter] = ArrayBuffer[PlayerCharacter](),
                     nextPanelsInput: ArrayBuffer[PanelTrait] = ArrayBuffer[PanelTrait]())
                    extends PanelAbstract(
                      "Encounter",
                      charactersInput,
                      nextPanelsInput) {

  /**If the Player stops on an encounter Panel, it triggers
   * a battle between the Player and a randomly generated Wild Unit.
   *
   * @param character The Player that stops on this Panel. Calls to it's Battle() method.
   */
  def stop(character: PlayerCharacter): Unit = {
    //* Uses class constructor to create a new Random Wild Unit and battles it*/
  }
}
