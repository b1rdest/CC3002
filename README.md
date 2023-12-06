# 99.7% Citric Liquid
Readme in "spanglish", by Diego Vergara V.
## About

`99.7% Citric Liquid` is a simplified clone of the renowned game, `100% Orange Juice`. Its main
purpose is to serve as an educational tool, teaching foundational programming concepts.

📢 **Note**: This project is purely educational and will not be used for any commercial purposes.

---
## Entrega Final 3 !!!!!!!!!!!!!!!!!1111

## Patchnotes

###  The game is (somehow) playable!!!!
- Just execute the main file on the game folder and you will be able to play on the terminal. For some reason, only lowercase prompts work, despite being asked for an uppercase prompt.
- Warning! It is very boring!

### To do list:
- Terminate a more complex implementation of the Observer pattern for the victory condition
- Test and handle exceptions

#### ☆ New package game
- GameController: Implements the State Design Pattern. It governs state transitions and stores important variables.
- StartState: the first state of the game. It prompts the player for the name of the PlayerCharacters and sets up the Player list, the turn order and the board
- ChapterStart: this state is called at the beginning of each chapter. It checks if all chapters have been played (99 by default), if true, the lead to the end of the game. If not, it simply jumps to the next turn.

#### ☆ New package: utility
- InputHandler: object made for receiving terminal inputs. Made so it can be overriden in tests that require player input. Also avoids code duplication for prompts. It may prove to be a privacy risk, but it was the only way I found to test functions with inputs
- Factory: trait for implementing the "Factory Method" Design Pattern
- Player Factory: prompts the user for a name and creates a character with standard stats.
- Enemy Factory: helps create enemies with two methods: one that creates a random creature, and another one that creates a specific enemy.
- Random Panel Factory: creates a random panel between those that are defined, or creates a specific panel, excluding home panels
- Board Factory: returns a sequence of Panels of an specified length.

#### For Units:
- All units are now *completely* tested!!!
- Dead units can not be attacked now.
- Improved privacy for *most* variables
- PlayerUnit now has setter setPanel.
- PlayerUnit now has variable controller: GameController, which is passed to norma, so the Observer pattern can be constructed

#### For Board:
- All boards are *mostly* tested
- If a player lands on a tile with more than one player, they will alway fight the first one that appears on the list

#### For Norma:
- New Abstract Class: NormaAbstract. made so it can implement the commmon method updateGoal()
- Now Norma class has two new variables: player, and controller: the subscriber.

#### Ideas:
- Implement a template method for a general battle, then the steps change depending if the player is fighting another player or a wild unit. This could prevent code duplication. For now, the Player vs WildUnit battle code is handled by the encounter panel, and the player vs player battle is handled by PanelAbstract

#### Known Problems: 
- Players can infinitely stop on their Home Panel, healing completely

#### Solved Problems:
- PlayerCharacter's currentPanel now is modified correctly
- Fixed problem where dead GameUnits could be attacked
- Fixed problem where GameUnits where able to have negative stars

<div style="text-align:center;">
    <img src="https://i.creativecommons.org/l/by/4.0/88x31.png" alt="Creative Commons License">
</div>

This project is licensed under the [Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/).

---