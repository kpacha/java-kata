package com.github.kpacha.jkata.pokerhand.hand;

import java.util.ArrayList;
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
    protected AbstractPokerHandArchetype processHand(List<PokerCard> cards) {
	Collections.sort(cards);
	List<PokerCard> straight = getHigherStraight(cards);
	if (straight.size() > 4) {
	    higherCard = findHigherCard(straight);
	    lowerCard = straight.get(straight.size() - 5);
	    isStraight = true;
	}
	return this;
    }

    private List<PokerCard> getHigherStraight(List<PokerCard> cards) {
	List<PokerCard> straight = new ArrayList<PokerCard>();
	for (int i = cards.size() - 5; i >= 0; i--) {
	    straight = getStraight(cards.subList(i, i + 5));
	    if (straight.size() > 4) {
		break;
	    }
	}
	return straight;
    }

    private List<PokerCard> getStraight(List<PokerCard> cards) {
	List<PokerCard> straight = new ArrayList<PokerCard>();
	straight.add(cards.get(0));
	for (int currentCard = 1; currentCard < 5; currentCard++) {
	    if (straight.get(straight.size() - 1).compareTo(
		    cards.get(currentCard)) == -1) {
		straight.add(cards.get(currentCard));
	    } else {
		straight = new ArrayList<PokerCard>();
		break;
	    }
	}
	return straight;
    }

    @Override
    public boolean match() {
	return isStraight;
    }

}
