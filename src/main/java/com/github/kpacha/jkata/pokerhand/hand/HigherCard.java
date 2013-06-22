package com.github.kpacha.jkata.pokerhand.hand;

import java.util.Collections;
import java.util.List;

import com.github.kpacha.jkata.pokerhand.AbstractPokerHandArchetype;
import com.github.kpacha.jkata.pokerhand.PokerCard;

public class HigherCard extends AbstractPokerHandArchetype {

    protected PokerCard higherCard = null;

    public HigherCard() {
	name = "High Card";
	rank = 0;
    }

    @Override
    public String getHandDescription() {
	return higherCard.getCardValue();
    }

    private PokerCard findHigherCard(List<PokerCard> hand) {
	Collections.sort(hand);
	return hand.get(4);
    }

    public int getNumericValue() {
	return higherCard.getNumericValue();
    }

    @Override
    protected AbstractPokerHandArchetype processHand() {
	higherCard = findHigherCard(hand.getCards());
	return this;
    }

    @Override
    public boolean match() {
	return true;
    }

    @Override
    public int compareEqualRanked(AbstractPokerHandArchetype hand) {
	return higherCard.getNumericValue()
		- ((HigherCard) hand).getNumericValue();
    }
}
