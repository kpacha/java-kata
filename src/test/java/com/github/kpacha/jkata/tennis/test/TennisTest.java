package com.github.kpacha.jkata.tennis.test;

import junit.framework.TestCase;

import org.junit.Test;

import com.github.kpacha.jkata.tennis.Tennis;

public class TennisTest extends TestCase {

    @Test
    public void testInitialScore() {
	Tennis game = new Tennis();
	assertEquals("0 - 0", game.getScore());
    }

    @Test
    public void testFirstPointScore() {
	Tennis game = new Tennis();
	game.playerOneScores();
	assertEquals("15 - 0", game.getScore());
    }
}
