package com.github.kpacha.jkata.pokerhand;

import java.util.List;

public abstract class AbstractPokerHandArchetype {

    protected String name;
    protected int rank;
    protected PokerHand hand;

    public AbstractPokerHandArchetype processHand(PokerHand hand) {
	this.hand = hand;
	return processHand();
    }

    public String getName() {
	return name;
    }

    public int getHandRank() {
	return rank;
    }

    public abstract String getHandDescription();

    protected abstract AbstractPokerHandArchetype processHand();

    public abstract boolean match();

    public abstract int getNumericValue();

    public int compareTo(AbstractPokerHandArchetype hand) {
	int rankDifference = rank - hand.getHandRank();
	if (rankDifference == 0)
	    rankDifference = compareEqualRanked(hand);
	return rankDifference;
    }

    protected int compareEqualRanked(AbstractPokerHandArchetype hand) {
	int difference = getNumericValue() - hand.getNumericValue();
	if (difference == 0) {
	    List<PokerCard> cardsToCompare = hand.getCards();
	    for (int currentCard = 4; currentCard >= 0 && difference == 0; currentCard--) {
		difference = this.hand.getCards().get(currentCard)
			.getNumericValue()
			- cardsToCompare.get(currentCard).getNumericValue();
	    }
	}
	return difference;
    }

    public List<PokerCard> getCards() {
	return hand.getCards();
    }
}
