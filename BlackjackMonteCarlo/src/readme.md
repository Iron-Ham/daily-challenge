# Monte Carlo Simulation of Blackjack

## Running
Compile all java files, and execute the PlayBlackjack class.

`cd /path/to/src/`

`javac *.java && java PlayBlackjack`

## Assumptions
1. Dealer does not hit on a soft-17 (17 with an ace counting as an 11).
2. The game is played in casino-rotation (players first, then dealer). If we assume that the game is played in sequence, there is a note in the Blackjack.java file which explains how to accommodate for that.

## Output
Program outputs the result of each game of blackjack, along with the cards held by the player and dealer.

Casino-rules blackjack: Win rate hovers around 30%

Sequential-play blackjack: Win-rate hovers around 37%
