package com.github.kpacha.jkata.pokerhand.hand;

import java.util.List;

import com.github.kpacha.jkata.pokerhand.AbstractPokerHandArchetype;
import com.github.kpacha.jkata.pokerhand.PokerCard;

public class FullHouse extends TwoPairs {

    public FullHouse() {
	name = "Full House";
	rank = 6;
    }

    @Override
    public AbstractPokerHandArchetype processHand(List<PokerCard> cards) {
	PokerCard firstPair = findNOfAKind(cards, null, 2);
	PokerCard secondPair = findNOfAKind(cards, firstPair, 1);
	if (firstPair != null && secondPair != null) {
	    higherScored = firstPair;
	    lowerScored = secondPair;
	}
	return this;
    }

}
