package com.github.kpacha.jkata.pokerhand.hand;

import com.github.kpacha.jkata.pokerhand.AbstractPokerHandArchetype;

public class StraightFlush extends Flush {

    private Straight straight = null;
    private boolean isStraightFlush = false;

    public StraightFlush() {
	name = "Straight Flush";
	rank = 8;
    }

    @Override
    protected AbstractPokerHandArchetype processHand() {
	super.processHand();
	if (isFlush) {
	    straight = new Straight();
	    isStraightFlush = straight.processHand(hand).match();
	}
	return this;
    }

    @Override
    public boolean match() {
	return isStraightFlush;
    }

}
