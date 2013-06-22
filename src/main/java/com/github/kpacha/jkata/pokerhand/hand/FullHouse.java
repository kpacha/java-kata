package com.github.kpacha.jkata.pokerhand.hand;

import com.github.kpacha.jkata.pokerhand.AbstractPokerHandArchetype;
import com.github.kpacha.jkata.pokerhand.PokerCard;

public class FullHouse extends TwoPairs {

    public FullHouse() {
	name = "Full House";
	rank = 6;
    }

    @Override
    public AbstractPokerHandArchetype processHand() {
	PokerCard firstPair = findNOfAKind(hand.getCards(), null, 2);
	PokerCard secondPair = findNOfAKind(hand.getCards(), firstPair, 1);
	if (firstPair != null && secondPair != null) {
	    higherScored = firstPair;
	    lowerScored = secondPair;
	}
	return this;
    }

}
