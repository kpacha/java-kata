package com.github.kpacha.jkata.pokerhand.test;

import junit.framework.TestCase;

import org.junit.Test;

import com.github.kpacha.jkata.pokerhand.PokerCard;
import com.github.kpacha.jkata.pokerhand.PokerHand;

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
    public void testGetTenAsNumericValue() {
	PokerCard card = new PokerCard("TH");
	assertEquals(10, card.getNumericValue());
    }

    @Test
    public void testGetJackAsNumericValue() {
	PokerCard card = new PokerCard("JH");
	assertEquals(11, card.getNumericValue());
    }

    @Test
    public void testGetQueenAsNumericValue() {
	PokerCard card = new PokerCard("QH");
	assertEquals(12, card.getNumericValue());
    }

    @Test
    public void testGetKingAsNumericValue() {
	PokerCard card = new PokerCard("KH");
	assertEquals(13, card.getNumericValue());
    }

    @Test
    public void testGetAceAsNumericValue() {
	PokerCard card = new PokerCard("AH");
	assertEquals(14, card.getNumericValue());
    }

    @Test
    public void testGetHigherCard() {
	PokerCard higherCard = new PokerCard("AH");
	PokerCard lowerCard = new PokerCard("5H");
	assertTrue(higherCard.compareTo(lowerCard) > 0);
    }

    @Test
    public void testFindHigherCardOfAHand() {
	PokerHand hand = new PokerHand("AH", "5H", "9S", "3S", "2C");
	assertEquals("High Card : A", hand.findHand());
    }

    @Test
    public void testDetectAPair() {
	PokerHand hand = new PokerHand("AH", "5H", "9S", "3S", "9C");
	assertEquals("Pair : 9", hand.findHand());
    }

    @Test
    public void testDetectTwoPairs() {
	PokerHand hand = new PokerHand("AH", "5H", "9S", "5S", "9C");
	assertEquals("Two Pairs : 9&5", hand.findHand());
    }

    @Test
    public void testDetectThreeOfAKind() {
	PokerHand hand = new PokerHand("AH", "5H", "5C", "5S", "9C");
	assertEquals("Three Of A Kind : 5", hand.findHand());
    }

    @Test
    public void testDetectFourOfAKind() {
	PokerHand hand = new PokerHand("AH", "5H", "5C", "5S", "5D");
	assertEquals("Poker : 5", hand.findHand());
    }

    @Test
    public void testDetectStraight() {
	PokerHand hand = new PokerHand("2H", "5H", "4C", "3S", "6D");
	assertEquals("Straight : 2-6", hand.findHand());
    }

    @Test
    public void testDetectFlush() {
	PokerHand hand = new PokerHand("2H", "5H", "4H", "AH", "TH");
	assertEquals("Flush : H TO A", hand.findHand());
    }

    @Test
    public void testDetectFullHouse() {
	PokerHand hand = new PokerHand("2H", "2S", "2C", "TC", "TH");
	assertEquals("Full House : 2&T", hand.findHand());
    }

    @Test
    public void testDetectStraightFlush() {
	PokerHand hand = new PokerHand("2H", "5H", "4H", "3H", "6H");
	assertEquals("Straight Flush : H TO 6", hand.findHand());
    }

    @Test
    public void testPairWinsHigherCard() {
	PokerHand pairHand = new PokerHand("2H", "5H", "9S", "3S", "9C");
	PokerHand loserHand = new PokerHand("AH", "5H", "KS", "3S", "9C");
	assertTrue(pairHand.compareTo(loserHand) > 0);
    }

    @Test
    public void testTwoPairsWinASinglePair() {
	PokerHand winnerHand = new PokerHand("2H", "5H", "9S", "2S", "9C");
	PokerHand loserHand = new PokerHand("AH", "5H", "KS", "3S", "AC");
	assertTrue(winnerHand.compareTo(loserHand) > 0);
    }

    @Test
    public void testThreeOfAKindWinTwoPairs() {
	PokerHand winnerHand = new PokerHand("2H", "5H", "2C", "2S", "9C");
	PokerHand loserHand = new PokerHand("AH", "KH", "KS", "3S", "AC");
	assertTrue(winnerHand.compareTo(loserHand) > 0);
    }

    @Test
    public void testStraightWinThreeOfAKind() {
	PokerHand loserHand = new PokerHand("2H", "5H", "2C", "2S", "9C");
	PokerHand winnerHand = new PokerHand("2H", "5H", "4C", "3S", "6D");
	assertTrue(winnerHand.compareTo(loserHand) > 0);
    }

    @Test
    public void testFlushWinsStraight() {
	PokerHand winnerHand = new PokerHand("2H", "5H", "4H", "AH", "TH");
	PokerHand loserHand = new PokerHand("2H", "5H", "4C", "3S", "6D");
	assertTrue(winnerHand.compareTo(loserHand) > 0);
    }

    @Test
    public void testAFullHouseWinsAFlush() {
	PokerHand winnerHand = new PokerHand("2H", "2S", "TS", "TC", "TH");
	PokerHand loserHand = new PokerHand("2H", "5H", "4H", "AH", "TH");
	assertTrue(winnerHand.compareTo(loserHand) > 0);
    }

    @Test
    public void testAPokerWinsAFullHouse() {
	PokerHand winnerHand = new PokerHand("3H", "3S", "3D", "3C", "TH");
	PokerHand loserHand = new PokerHand("2H", "2S", "TS", "TC", "TH");
	assertTrue(winnerHand.compareTo(loserHand) > 0);
    }

    @Test
    public void testDetetcTheHigherFullHouse() {
	PokerHand winnerHand = new PokerHand("3H", "3S", "3D", "TD", "TS");
	PokerHand loserHand = new PokerHand("2H", "2S", "2S", "TC", "TH");
	assertTrue(winnerHand.compareTo(loserHand) > 0);
    }

    @Test
    public void testAStraightFlushWinsAPoker() {
	PokerHand winnerHand = new PokerHand("9H", "QH", "JH", "KH", "TH");
	PokerHand loserHand = new PokerHand("3H", "3S", "3D", "3C", "TH");
	assertTrue(winnerHand.compareTo(loserHand) > 0);
    }

    @Test
    public void testDetectTheHigherPair() {
	PokerHand winnerHand = new PokerHand("9H", "9S", "3C", "4H", "TC");
	PokerHand loserHand = new PokerHand("2H", "5S", "8C", "8D", "TH");
	assertTrue(winnerHand.compareTo(loserHand) > 0);
    }

    @Test
    public void testDetectTheHigherPairByAThirdCard() {
	PokerHand winnerHand = new PokerHand("9H", "9S", "AC", "4H", "TC");
	PokerHand loserHand = new PokerHand("2H", "5S", "9C", "9D", "TH");
	assertTrue(winnerHand.compareTo(loserHand) > 0);
    }

    @Test
    public void testDetectTheHigherPairByAFouthCard() {
	PokerHand winnerHand = new PokerHand("9H", "9S", "3C", "7H", "TC");
	PokerHand loserHand = new PokerHand("2H", "5S", "8C", "8D", "TH");
	assertTrue(winnerHand.compareTo(loserHand) > 0);
    }

    @Test
    public void testDetectTheHigherPairByTheFithCard() {
	PokerHand winnerHand = new PokerHand("9H", "9S", "3C", "4H", "TC");
	PokerHand loserHand = new PokerHand("2H", "4S", "8C", "8D", "TH");
	assertTrue(winnerHand.compareTo(loserHand) > 0);
    }

    @Test
    public void testDetectTheHigherTwoPairsByBiggerPair() {
	PokerHand winnerHand = new PokerHand("9H", "9S", "3C", "3H", "TC");
	PokerHand loserHand = new PokerHand("2H", "2S", "8C", "8D", "TH");
	assertTrue(winnerHand.compareTo(loserHand) > 0);
    }

    @Test
    public void testDetectTheHigherTwoPairsBySecondPair() {
	PokerHand winnerHand = new PokerHand("9H", "9S", "3C", "3H", "TC");
	PokerHand loserHand = new PokerHand("2H", "2S", "9C", "9D", "TH");
	assertTrue(winnerHand.compareTo(loserHand) > 0);
    }

    @Test
    public void testDetectTheHigherTwoPairsByFithCard() {
	PokerHand winnerHand = new PokerHand("9H", "9S", "3C", "3H", "TC");
	PokerHand loserHand = new PokerHand("3H", "3S", "9C", "9D", "5H");
	assertTrue(winnerHand.compareTo(loserHand) > 0);
    }

    @Test
    public void testDetectTheHigherThreeOfAKind() {
	PokerHand winnerHand = new PokerHand("9H", "9S", "9C", "3H", "TC");
	PokerHand loserHand = new PokerHand("2H", "2S", "2C", "AH", "TH");
	assertTrue(winnerHand.compareTo(loserHand) > 0);
    }

    @Test
    public void testDetectTheHigherPoker() {
	PokerHand winnerHand = new PokerHand("9H", "9H", "9H", "9H", "TH");
	PokerHand loserHand = new PokerHand("2H", "2H", "2H", "2H", "6H");
	assertTrue(winnerHand.compareTo(loserHand) > 0);
    }

    @Test
    public void testDetectTheHigherStraightFlush() {
	PokerHand winnerHand = new PokerHand("9H", "QH", "JH", "KH", "TH");
	PokerHand loserHand = new PokerHand("3H", "2H", "5H", "4H", "6H");
	assertTrue(winnerHand.compareTo(loserHand) > 0);
    }

    @Test
    public void testDetectTheHigherStraight() {
	PokerHand winnerHand = new PokerHand("9H", "QD", "JH", "KH", "TH");
	PokerHand loserHand = new PokerHand("3H", "2H", "5D", "4H", "6H");
	assertTrue(winnerHand.compareTo(loserHand) > 0);
    }

    @Test
    public void testDetectTheHigherFlush() {
	PokerHand winnerHand = new PokerHand("9H", "QH", "3H", "KH", "AH");
	PokerHand loserHand = new PokerHand("2H", "7H", "5H", "4H", "6H");
	assertTrue(winnerHand.compareTo(loserHand) > 0);
    }

    @Test
    public void testDetectTie() {
	PokerHand firstHand = new PokerHand("2H", "3D", "5S", "9C", "KD");
	PokerHand secondHand = new PokerHand("2C", "3S", "5H", "9S", "KH");
	assertTrue(firstHand.compareTo(secondHand) == 0);
    }

    @Test
    public void testDetectWinnerByTheSecondHigherCard() {
	PokerHand firstHand = new PokerHand("2H", "3D", "5S", "9C", "KD");
	PokerHand loserHand = new PokerHand("2C", "3S", "5H", "8S", "KH");
	assertTrue(firstHand.compareTo(loserHand) > 0);
    }
}
