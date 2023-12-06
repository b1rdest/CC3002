package cl.uchile.dcc.citric
package model.utility

import model.board._

/* Creates a sequence of random panels (excluding HomePanel) of a defined size
* The first panel (always a neutral panel )is returned */
class BoardFactory extends Factory {
  def create(length: Int): Panel = {
    val factory = new RandomPanelFactory
    val panelInicial = new NeutralPanel()
    var next: Panel = panelInicial
    for (i <- Range.inclusive(0, length-1)) {
      next.nextPanels += factory.create()
      next = next.nextPanels(0)
    }
    panelInicial
  }
  /* Creates a sequence of only one panel */
  def create():Panel = {
    create(1)
  }
}
