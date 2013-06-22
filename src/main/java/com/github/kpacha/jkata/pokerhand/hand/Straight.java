package com.github.kpacha.jkata.pokerhand.hand;

import java.util.Collections;
import java.util.List;

import com.github.kpacha.jkata.pokerhand.AbstractPokerHandArchetype;
import com.github.kpacha.jkata.pokerhand.PokerCard;

public class Straight extends HigherCard {

    private PokerCard lowerCard = null;
    protected boolean isStraight = false;

    public Straight() {
	name = "Straight";
	rank = 4;
    }

    @Override
    public String getHandDescription() {
	return lowerCard.getCardValue() + "-" + higherCard.getCardValue();
    }

    @Override
    protected AbstractPokerHandArchetype processHand() {
	List<PokerCard> cards = hand.getCards();
	Collections.sort(cards);
	boolean isStraight = true;
	for (int currentCard = 0; currentCard < 4; currentCard++) {
	    if (cards.get(currentCard).compareTo(cards.get(currentCard + 1)) != -1) {
		isStraight = false;
		break;
	    }
	}
	if (isStraight) {
	    higherCard = cards.get(4);
	    lowerCard = cards.get(0);
	}
	this.isStraight = isStraight;
	return this;
    }

    @Override
    public boolean match() {
	return isStraight;
    }

}
