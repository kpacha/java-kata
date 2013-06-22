package com.github.kpacha.jkata.tennis;

import java.util.HashMap;
import java.util.Map;

public class Tennis {

    private int playerOneScored = 0;
    private int playerTwoScored = 0;
    private Map<Integer, String> equivalencies = new HashMap<Integer, String>() {
	{
	    put(0, "0");
	    put(1, "15");
	    put(2, "30");
	    put(3, "40");
	}
    };

    public String getScore() {
	if (isDeuce())
	    return "Deuce";
	if (isAdvantagePlayerOne())
	    return "Advantage Player 1";
	if (isAdvantagePlayerTwo())
	    return "Advantage Player 2";
	if (playerOneWins())
	    return "Player 1 wins";
	if (playerTwoWins())
	    return "Player 2 wins";
	return getScoreValue(playerOneScored) + " - "
		+ getScoreValue(playerTwoScored);
    }

    private String getScoreValue(int points) {
	return equivalencies.get(points);
    }

    private boolean playerOneWins() {
	return playerOneScored > 3 && playerOneScored > playerTwoScored + 1;
    }

    private boolean playerTwoWins() {
	return playerTwoScored > 3 && playerTwoScored > playerOneScored + 1;
    }

    private boolean isAdvantagePlayerOne() {
	return playerOneScored == playerTwoScored + 1 && playerOneScored > 3;
    }

    private boolean isAdvantagePlayerTwo() {
	return playerOneScored + 1 == playerTwoScored && playerTwoScored > 3;
    }

    private boolean isDeuce() {
	return playerOneScored == playerTwoScored && playerTwoScored > 2;
    }

    public void playerOneScores() {
	playerOneScored++;
    }

    public void playerTwoScores() {
	playerTwoScored++;
    }
}
