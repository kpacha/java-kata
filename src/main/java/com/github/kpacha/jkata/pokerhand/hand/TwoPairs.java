package com.github.kpacha.jkata.pokerhand.hand;

import java.util.List;

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
	return higherScored.getNumericValue() * 20
		+ lowerScored.getNumericValue();
    }

    @Override
    public AbstractPokerHandArchetype processHand(List<PokerCard> cards) {
	PokerCard firstPair = findNOfAKind(cards, null, 1);
	PokerCard secondPair = findNOfAKind(cards, firstPair, 1);
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
	int difference = getNumericValue() - hand.getNumericValue();
	if (difference == 0) {
	    difference = super.compareEqualRanked(hand);
	}
	return difference;
    }
}
