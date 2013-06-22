package com.github.kpacha.jkata.pokerhand;

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

    public int compareTo(AbstractPokerHandArchetype hand) {
	if (rank == hand.getHandRank())
	    return compareEqualRanked(hand);
	return rank - hand.getHandRank();
    }

    public abstract int compareEqualRanked(AbstractPokerHandArchetype hand);
}
