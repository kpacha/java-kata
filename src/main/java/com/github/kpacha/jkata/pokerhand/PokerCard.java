package com.github.kpacha.jkata.pokerhand;

public class PokerCard {

    private String card;

    public PokerCard(String card) {
	this.card = card;
    }

    public int getNumericValue() {
	if (card.charAt(0) == 'A')
	    return 13;
	if (card.charAt(0) == 'K')
	    return 12;
	if (card.charAt(0) == 'Q')
	    return 11;
	if (card.charAt(0) == 'J')
	    return 10;
	return Integer.parseInt(card.substring(0, 1));
    }
}
