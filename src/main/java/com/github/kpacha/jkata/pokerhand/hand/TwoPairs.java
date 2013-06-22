package com.github.kpacha.jkata.pokerhand.hand;

import com.github.kpacha.jkata.pokerhand.AbstractPokerHandArchetype;
import com.github.kpacha.jkata.pokerhand.PokerCard;

public class TwoPairs extends AbstractNumberOfAKind {

    private PokerCard higherPair = null;
    private PokerCard lowerPair = null;

    public TwoPairs() {
	name = "Two Pairs";
	rank = 2;
    }

    @Override
    public String getHandDescription() {
	return higherPair.getCardValue() + "&" + lowerPair.getCardValue();
    }

    public int getNumericValue() {
	return higherPair.getNumericValue() * 20 + lowerPair.getNumericValue();
    }

    @Override
    public AbstractPokerHandArchetype processHand() {
	PokerCard firstPair = findNOfAKind(hand.getCards(), null, 1);
	PokerCard secondPair = findNOfAKind(hand.getCards(), firstPair, 1);
	if (firstPair != null && secondPair != null) {
	    if (firstPair.getNumericValue() < secondPair.getNumericValue()) {
		higherPair = secondPair;
		lowerPair = firstPair;
	    } else {
		higherPair = firstPair;
		lowerPair = secondPair;
	    }
	}
	return this;
    }

    @Override
    public boolean match() {
	return higherPair != null && lowerPair != null;
    }

    @Override
    public int compareEqualRanked(AbstractPokerHandArchetype hand) {
	return getNumericValue() - ((TwoPairs) hand).getNumericValue();
    }
}
