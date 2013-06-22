package com.github.kpacha.jkata.pokerhand.hand;

import java.util.Collections;
import java.util.List;

import com.github.kpacha.jkata.pokerhand.AbstractPokerHandArchetype;
import com.github.kpacha.jkata.pokerhand.PokerCard;

public class Flush extends HigherCard {

    private String suit = null;
    protected boolean isFlush = false;

    public Flush() {
	name = "Flush";
	rank = 5;
    }

    @Override
    public String getHandDescription() {
	return suit + " TO " + higherCard.getCardValue();
    }

    @Override
    protected AbstractPokerHandArchetype processHand() {
	List<PokerCard> cards = hand.getCards();
	Collections.sort(cards);
	boolean isFlush = true;
	for (int currentCard = 0; currentCard < 4; currentCard++) {
	    if (!cards.get(currentCard).getCardSuit()
		    .equals(cards.get(currentCard + 1).getCardSuit())) {
		isFlush = false;
		break;
	    }
	}
	if (isFlush) {
	    higherCard = cards.get(4);
	    suit = higherCard.getCardSuit();
	}
	this.isFlush = isFlush;
	return this;
    }

    @Override
    public boolean match() {
	return isFlush;
    }

}
