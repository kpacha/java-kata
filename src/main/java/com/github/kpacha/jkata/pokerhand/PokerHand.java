package com.github.kpacha.jkata.pokerhand;

import java.util.ArrayList;
import java.util.List;

public class PokerHand {

    private List<PokerCard> hand;

    public PokerHand(String card1, String card2, String card3, String card4,
	    String card5) {
	hand = new ArrayList<PokerCard>(5);
	hand.add(new PokerCard(card1));
	hand.add(new PokerCard(card2));
	hand.add(new PokerCard(card3));
	hand.add(new PokerCard(card4));
	hand.add(new PokerCard(card5));
    }

    public String findHand() {
	String result;
	List<PokerCard> pairs = findTwoPairs();
	if (pairs != null) {
	    result = "Two Pairs : " + pairs.get(0).getCardValue() + "&"
		    + pairs.get(1).getCardValue();
	} else {
	    PokerCard pair = findPair();
	    if (pair != null)
		result = "Pair : " + pair.getCardValue();
	    else
		result = "High Card : " + findHigherCard().getCardValue();
	}
	return result;
    }

    private List<PokerCard> findTwoPairs() {
	List<PokerCard> result = null;
	PokerCard firstPair = findPair();
	PokerCard secondPair = findPair(firstPair);
	if (firstPair != null && secondPair != null) {
	    result = new ArrayList<PokerCard>(2);
	    if (firstPair.getNumericValue() < secondPair.getNumericValue()) {
		result.add(secondPair);
		result.add(firstPair);
	    } else {
		result.add(firstPair);
		result.add(secondPair);
	    }
	}
	return result;
    }

    private PokerCard findPair(PokerCard cardToAvoid) {
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

    private PokerCard findPair() {
	return findPair(null);
    }

    private PokerCard findHigherCard() {
	PokerCard higherCard = hand.get(0);
	for (PokerCard currentCard : hand) {
	    if (higherCard.compareTo(currentCard) < 0) {
		higherCard = currentCard;
	    }
	}
	return higherCard;
    }
}
