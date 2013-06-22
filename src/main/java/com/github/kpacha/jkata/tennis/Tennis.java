package com.github.kpacha.jkata.tennis;

public class Tennis {

    private int playerOneScored = 0;
    private int playerTwoScored = 0;

    public String getScore() {
	if (playerOneScored == 3 && playerTwoScored == 3
		|| playerOneScored == 4 && playerTwoScored == 4)
	    return "Deuce";
	if (playerOneScored == 4) {
	    if (playerTwoScored == 3)
		return "Advantage Player 1";
	    else
		return "Player 1 wins";
	}
	return (15 * playerOneScored) + " - " + (15 * playerTwoScored);
    }

    public void playerOneScores() {
	playerOneScored++;
    }

    public void playerTwoScores() {
	playerTwoScored++;
    }
}
