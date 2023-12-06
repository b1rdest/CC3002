package cl.uchile.dcc.citric
package model.game

import model.unit.PlayerCharacter
import model.board._

import scala.collection.mutable.ArrayBuffer
import model.utility._

import scala.collection.mutable._

/* Initial values are set up
* Players are created and the board is defined*/
class StartState(controller: GameController) extends GameState {
  var inputHandler = new InputHandler
  def start(controller: GameController):Unit = {
    println("Welcome to 99.7% Citric Liquid!")
    println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠟⠛⠛⠛⠛⠻⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n⣿⣿⣿⣿⣿⣿⡿⠟⠋⠁⠀⢀⣤⣶⣶⣶⣶⣤⡀⠀⠈⠙⠻⢿⣿⣿⣿⣿⣿⣿\n⣿⣿⣿⣿⡿⠋⢀⣴⣶⣦⡀⠸⣿⣿⣿⣿⣿⣿⠇⢀⣴⣶⣦⣀⠙⢿⣿⣿⣿⣿\n⣿⣿⣿⠏⠀⣴⣿⣿⣿⣿⣷⡀⢿⣿⣿⣿⣿⡟⢀⣾⣿⣿⣿⣿⣧⡀⠹⣿⣿⣿\n⣿⣿⠏⠀⠸⣿⣿⣿⣿⣿⣿⣷⡘⣿⣿⣿⣿⢁⣾⣿⣿⣿⣿⣿⣿⠇⠀⠹⣿⣿\n⣿⡏⠀⢀⣀⡈⠙⠻⢿⣿⣿⣿⣷⣹⣿⣿⣯⣾⣿⣿⣿⡿⠟⠋⢁⣀⡀⠀⢹⣿\n⣿⠁⢠⣿⣿⣿⣿⣷⣶⣬⣝⣻⣿⠟⠋⠙⠻⣿⣟⣫⣥⣶⣶⣿⣿⣿⣿⡄⠈⣿\n⣿⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣏⠀⠀⠀⠀⣹⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⣿\n⣿⡀⠘⣿⣿⣿⣿⠿⠟⢛⣯⣿⣿⣦⣄⣠⣴⣿⣿⣝⡛⠿⢿⣿⣿⣿⣿⠃⢀⣿\n⣿⣇⠀⠈⠉⢁⣠⣴⣾⣿⣿⣿⡿⣹⣿⣿⣟⢿⣿⣿⣿⣷⣦⣄⡈⠉⠁⠀⣸⣿\n⣿⣿⣆⠀⢰⣿⣿⣿⣿⣿⣿⡿⢡⣿⣿⣿⣿⡈⢿⣿⣿⣿⣿⣿⣿⡆⠀⣰⣿⣿\n⣿⣿⣿⣆⠈⠻⣿⣿⣿⣿⡿⠁⣾⣿⣿⣿⣿⣧⠈⢿⣿⣿⣿⣿⡟⠁⣰⣿⣿⣿\n⣿⣿⣿⣿⣷⣄⠈⠛⠿⠟⠁⢸⣿⣿⣿⣿⣿⣿⡆⠈⠻⠿⠟⠉⣠⣾⣿⣿⣿⣿\n⣿⣿⣿⣿⣿⣿⣷⣦⣄⡀⠀⠈⠛⠿⠿⠿⠿⠛⠁⠀⢀⣠⣴⣾⣿⣿⣿⣿⣿⣿\n⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣦⣤⣤⣤⣤⣴⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿")

    /* Se crean y se añaden los jugadores usando prompts del usuario */
    controller.players = new ArrayBuffer[PlayerCharacter]() //Se añaden los jugadores a esta lista
    val playerFactory: PlayerFactory = new PlayerFactory(controller)
    playerFactory.inputHandler = this.inputHandler
    val turns = Queue[PlayerCharacter]()
    for (i <- Range.inclusive(1, 4)) {
      println("Please, insert the name for player ".concat(i.toString))
      val newPlayer = playerFactory.create()
      controller.players.addOne(newPlayer)
      turns.enqueue(newPlayer)
    }
    controller.turnOrder = turns
    controller.chapters = 0

    /* A map is created */
    val boardFactory: BoardFactory = new BoardFactory
    var nowPanel: Panel = new HomePanel(ownerInput = controller.players(0))
    nowPanel.addCharacter(controller.players(0))
    controller.players(0).currentPanel = nowPanel
    nowPanel.addPanelatEnd(boardFactory.create(6))
    for (i <- Range.inclusive(1, 3)) {
      val homePanel = new HomePanel(ownerInput = controller.players(i))
      homePanel.addCharacter(controller.players(i))
      controller.players(i).currentPanel = homePanel
      nowPanel.addPanelatEnd(homePanel)
      nowPanel.addPanelatEnd(boardFactory.create(6))
    }
    nowPanel.addPanelatEnd(nowPanel) //This closes the map and makes it a cycle
    controller.currentPanel = nowPanel


    controller.changeState(new ChapterStart(controller))
  }


  def rollDice(): Unit = {
    /* Idea: like in Mario Party, players have to roll the dice to decide turns*/
    //controller.state = new /* ... */
  }

  def doEffect(): Unit = {
    this.start(controller)
  }
}