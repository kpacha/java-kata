package com.github.kpacha.jkata.pokerhand.hand;

import java.util.List;

import com.github.kpacha.jkata.pokerhand.AbstractPokerHandArchetype;
import com.github.kpacha.jkata.pokerhand.PokerCard;

public class AbstractNumberOfAKind extends AbstractPokerHandArchetype {

    private PokerCard subject = null;
    protected int numberOfAppearences = 0;

    @Override
    public String getHandDescription() {
	return subject.getCardValue();
    }

    @Override
    protected AbstractPokerHandArchetype processHand(List<PokerCard> cards) {
	subject = findNOfAKind(cards, null, numberOfAppearences);
	return this;
    }

    @Override
    public boolean match() {
	return subject != null;
    }

    @Override
    public int getNumericValue() {
	return subject.getNumericValue();
    }

    @Override
    protected int compareEqualRanked(AbstractPokerHandArchetype hand) {
	int difference = getNumericValue() - hand.getNumericValue();
	if (difference == 0) {
	    difference = super.compareEqualRanked(hand);
	}
	return difference;
    }

    public PokerCard findNOfAKind(List<PokerCard> hand, PokerCard cardToAvoid,
	    int expectedAppearences) {
	String cardValueToAvoid = (cardToAvoid != null) ? cardToAvoid
		.getCardValue() : "";
	PokerCard result = null;
	OUTERMOST: for (int i = 0; i < hand.size() - 1; i++) {
	    int appearances = 0;
	    if (hand.get(i).getCardValue().equals(cardValueToAvoid))
		continue;
	    for (int j = i + 1; j < hand.size(); j++) {
		if (hand.get(j).getCardValue().equals(cardValueToAvoid))
		    continue;
		if (hand.get(i).compareTo(hand.get(j)) == 0) {
		    appearances++;
		    if (appearances == expectedAppearences) {
			result = hand.get(i);
			break OUTERMOST;
		    }
		}
	    }
	}
	return result;
    }

}
