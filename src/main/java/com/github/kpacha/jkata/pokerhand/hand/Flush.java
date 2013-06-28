package com.github.kpacha.jkata.pokerhand.hand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.github.kpacha.jkata.pokerhand.AbstractPokerHandArchetype;
import com.github.kpacha.jkata.pokerhand.PokerCard;

public class Flush extends HigherCard {

    protected String suit = null;
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
    protected AbstractPokerHandArchetype processHand(List<PokerCard> cards) {
	for (Entry<String, Integer> suitCounter : getSuitCounter(cards)
		.entrySet()) {
	    if (suitCounter.getValue() > 4) {
		isFlush = true;
		suit = suitCounter.getKey();
		higherCard = findHigherCardBySuit(cards, suit);
		break;
	    }
	}
	return this;
    }

    private PokerCard findHigherCardBySuit(List<PokerCard> cards, String suit) {
	return findHigherCard(getFlush(cards, suit));
    }

    protected List<PokerCard> getFlush(List<PokerCard> cards, String suit) {
	List<PokerCard> bestCards = new ArrayList<PokerCard>();
	for (PokerCard card : cards) {
	    if (card.getCardSuit().equals(suit)) {
		bestCards.add(card);
	    }
	}
	return bestCards;
    }

    private Map<String, Integer> getSuitCounter(List<PokerCard> cards) {
	Map<String, Integer> suitCounter = new HashMap<String, Integer>() {
	    {
		put("H", 0);
		put("S", 0);
		put("D", 0);
		put("C", 0);
	    }
	};
	for (int currentCard = 0; currentCard < cards.size(); currentCard++) {
	    suitCounter.put(cards.get(currentCard).getCardSuit(),
		    suitCounter.get(cards.get(currentCard).getCardSuit()) + 1);
	}
	return suitCounter;
    }

    @Override
    public boolean match() {
	return isFlush;
    }

}
