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
}
