package com.github.kpacha.jkata.pokerhand.test;

import junit.framework.TestCase;

import org.junit.Test;

import com.github.kpacha.jkata.pokerhand.PokerCard;

public class PokerHandTest extends TestCase {

    @Test
    public void testGetFiveAsNumericValue() {
	PokerCard card = new PokerCard("5H");
	assertEquals(5, card.getNumericValue());
    }

    @Test
    public void testGetNineAsNumericValue() {
	PokerCard card = new PokerCard("9H");
	assertEquals(9, card.getNumericValue());
    }

    @Test
    public void testGetJackAsNumericValue() {
	PokerCard card = new PokerCard("JH");
	assertEquals(10, card.getNumericValue());
    }

    @Test
    public void testGetQueenAsNumericValue() {
	PokerCard card = new PokerCard("QH");
	assertEquals(11, card.getNumericValue());
    }

    @Test
    public void testGetKingAsNumericValue() {
	PokerCard card = new PokerCard("KH");
	assertEquals(12, card.getNumericValue());
    }
}
