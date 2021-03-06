package com.github.kpacha.jkata.holdem.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import com.github.kpacha.jkata.holdem.HoldEm;
import com.github.kpacha.jkata.pokerhand.PokerHand;

public class HoldEmTest extends TestCase {

    @Test
    public void testDetectAPair() {
	PokerHand hand = new PokerHand("2H", "8C", "3S", "9D", "2C", "TC", "AH");
	assertEquals("Pair : 2", hand.findHand());
    }

    @Test
    public void testDetectTwoPairs() {
	PokerHand hand = new PokerHand("2H", "9C", "3S", "9D", "2C", "TC", "AH");
	assertEquals("Two Pairs : 9&2", hand.findHand());
    }

    @Test
    public void testDetectThreeOfAKind() {
	PokerHand hand = new PokerHand("2H", "9C", "3S", "4D", "2C", "2C", "AH");
	assertEquals("Three Of A Kind : 2", hand.findHand());
    }

    @Test
    public void testDetectFullHouse() {
	PokerHand hand = new PokerHand("2H", "8C", "2S", "9D", "2C", "TC", "TH");
	assertEquals("Full House : 2&T", hand.findHand());
    }

    @Test
    public void testDetectFourOfAKind() {
	PokerHand hand = new PokerHand("AH", "5H", "5C", "5S", "5D", "TC", "TH");
	assertEquals("Poker : 5", hand.findHand());
    }

    @Test
    public void testDetectFlush() {
	PokerHand hand = new PokerHand("2H", "TC", "5H", "4H", "AH", "TH", "5D");
	assertEquals("Flush : H TO A", hand.findHand());
    }

    @Test
    public void testDetectStraight() {
	PokerHand hand = new PokerHand("8H", "5H", "4C", "7S", "6D", "2H", "KD");
	assertEquals("Straight : 4-8", hand.findHand());
    }

    @Test
    public void testDetectStraightFlush() {
	PokerHand hand = new PokerHand("2H", "4C", "5H", "4H", "3H", "KD", "6H");
	assertEquals("Straight Flush : H TO 6", hand.findHand());
    }

    @Test
    public void testDetectSeveralHands() {
	HoldEm holdEm = new HoldEm(getDummyHands());
	assertEquals((Integer) 0, holdEm.getWinner());
    }

    private List<PokerHand> getDummyHands() {
	List<PokerHand> hands = new ArrayList<PokerHand>();
	hands.add(new PokerHand("KC", "9S", "KS", "KD", "9D", "3C", "6D"));
	hands.add(new PokerHand("9C", "AH", "KS", "KD", "9D", "3C", "6D"));
	hands.add(new PokerHand("AC", "QC", "KS", "KD", "9D", "3C"));
	hands.add(new PokerHand("9H", "5S"));
	hands.add(new PokerHand("4D", "2D", "KS", "KD", "9D", "3C", "6D"));
	hands.add(new PokerHand("7S", "TS", "KS", "KD", "9D"));
	return hands;
    }

}
