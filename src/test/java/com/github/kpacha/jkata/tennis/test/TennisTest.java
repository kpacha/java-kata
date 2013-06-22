package com.github.kpacha.jkata.tennis.test;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import com.github.kpacha.jkata.tennis.Tennis;

public class TennisTest extends TestCase {

    private Tennis game;

    @Before
    public void setUp() {
	game = new Tennis();
    }

    private void playerOneScores(int times) {
	for (int counter = 0; counter < times; counter++)
	    game.playerOneScores();
    }

    @Test
    public void testInitialScore() {
	assertEquals("0 - 0", game.getScore());
    }

    @Test
    public void testFirstPointScore() {
	playerOneScores(1);
	assertEquals("15 - 0", game.getScore());
    }

    @Test
    public void testSecondPointScore() {
	playerOneScores(2);
	assertEquals("30 - 0", game.getScore());
    }

    @Test
    public void testThirdPointScore() {
	playerOneScores(3);
	assertEquals("45 - 0", game.getScore());
    }

    @Test
    public void testPlayerOneWinsScore() {
	playerOneScores(4);
	assertEquals("Player 1 wins", game.getScore());
    }
}
