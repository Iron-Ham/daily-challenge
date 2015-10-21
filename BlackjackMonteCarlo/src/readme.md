# Monte Carlo Simulation of Blackjack

## Running
**Requires Java 1.8 Compiler**. Open PlayBlackjack file. Ensure that parameters are set how you'd like them. Compile all java files, and run PlayBlackjack.

`cd /path/to/src/`

`javac *.java && java PlayBlackjack`

## Assumptions
1. Dealer does not hit on a soft-17 (17 with an ace counting as an 11).
2. If the player gets a blackjack (21 on first two cards), the player immediately wins. 

## Output
Program outputs the rates of each player of the game.

## Features

1. Support for multiple players. Technically unlimited, but since the game is played with 1 deck, keep it reasonable. 6 players is a reasonable cap. 
2. Players may hold at different values.
3. Robust models. These models can be re-used in any other project to do with cards and decks with little to no modification. 
