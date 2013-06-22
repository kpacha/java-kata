package com.github.kpacha.jkata.pokerhand.hand;

import java.util.List;

import com.github.kpacha.jkata.pokerhand.AbstractPokerHandArchetype;
import com.github.kpacha.jkata.pokerhand.PokerCard;

public class Pair extends AbstractPokerHandArchetype {

    private PokerCard pair = null;

    public Pair() {
	name = "Pair";
	rank = 1;
    }

    @Override
    public String getHandDescription() {
	return pair.getCardValue();
    }

    public PokerCard findPair(List<PokerCard> hand, PokerCard cardToAvoid) {
	String cardValueToAvoid = (cardToAvoid != null) ? cardToAvoid
		.getCardValue() : "";
	PokerCard result = null;
	OUTERMOST: for (int i = 0; i < 4; i++) {
	    if (hand.get(i).getCardValue().equals(cardValueToAvoid))
		continue;
	    for (int j = i + 1; j < 5; j++) {
		if (hand.get(j).getCardValue().equals(cardValueToAvoid))
		    continue;
		if (hand.get(i).compareTo(hand.get(j)) == 0) {
		    result = hand.get(i);
		    break OUTERMOST;
		}
	    }
	}
	return result;
    }

    public int getNumericValue() {
	return pair.getNumericValue();
    }

    @Override
    public AbstractPokerHandArchetype processHand() {
	pair = findPair(hand.getCards(), null);
	return this;
    }

    @Override
    public boolean match() {
	return pair != null;
    }

    @Override
    public int compareEqualRanked(AbstractPokerHandArchetype hand) {
	return pair.getNumericValue() - ((Pair) hand).getNumericValue();
    }
}
