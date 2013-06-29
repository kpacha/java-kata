package com.github.kpacha.jkata.holdem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.github.kpacha.jkata.pokerhand.PokerHand;

public class HoldEm {

    private List<PokerHand> players = null;

    public HoldEm(List<PokerHand> players) {
	this.players = players;
    }

    public Integer getWinner() {
	List<PokerHand> hands = new ArrayList<PokerHand>(players);
	Collections.sort(hands);
	int winner = -1;
	if (hands.get(hands.size() - 1).compareTo(hands.get(hands.size() - 2)) > 0) {
	    winner = players.indexOf(hands.get(hands.size() - 1));
	}
	return winner;
    }
}
