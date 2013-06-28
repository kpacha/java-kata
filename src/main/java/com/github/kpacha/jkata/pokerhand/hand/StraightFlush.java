package com.github.kpacha.jkata.pokerhand.hand;

import java.util.List;

import com.github.kpacha.jkata.pokerhand.AbstractPokerHandArchetype;
import com.github.kpacha.jkata.pokerhand.PokerCard;

public class StraightFlush extends Flush {

    private Straight straight = null;
    private boolean isStraightFlush = false;

    public StraightFlush() {
	name = "Straight Flush";
	rank = 8;
    }

    @Override
    protected AbstractPokerHandArchetype processHand(List<PokerCard> cards) {
	super.processHand(cards);
	if (isFlush) {
	    straight = new Straight();
	    isStraightFlush = straight.processHand(getFlush(cards, suit))
		    .match();
	}
	return this;
    }

    @Override
    public boolean match() {
	return isStraightFlush;
    }

}
