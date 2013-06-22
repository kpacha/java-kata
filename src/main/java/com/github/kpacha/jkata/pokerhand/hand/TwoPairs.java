package com.github.kpacha.jkata.pokerhand.hand;

import com.github.kpacha.jkata.pokerhand.AbstractPokerHandArchetype;
import com.github.kpacha.jkata.pokerhand.PokerCard;

public class TwoPairs extends AbstractNumberOfAKind {

    protected PokerCard higherScored = null;
    protected PokerCard lowerScored = null;

    public TwoPairs() {
	name = "Two Pairs";
	rank = 2;
    }

    @Override
    public String getHandDescription() {
	return higherScored.getCardValue() + "&" + lowerScored.getCardValue();
    }

    public int getNumericValue() {
	return higherScored.getNumericValue() * 20 + lowerScored.getNumericValue();
    }

    @Override
    public AbstractPokerHandArchetype processHand() {
	PokerCard firstPair = findNOfAKind(hand.getCards(), null, 1);
	PokerCard secondPair = findNOfAKind(hand.getCards(), firstPair, 1);
	if (firstPair != null && secondPair != null) {
	    if (firstPair.getNumericValue() < secondPair.getNumericValue()) {
		higherScored = secondPair;
		lowerScored = firstPair;
	    } else {
		higherScored = firstPair;
		lowerScored = secondPair;
	    }
	}
	return this;
    }

    @Override
    public boolean match() {
	return higherScored != null && lowerScored != null;
    }

    @Override
    public int compareEqualRanked(AbstractPokerHandArchetype hand) {
	return getNumericValue() - ((TwoPairs) hand).getNumericValue();
    }
}
