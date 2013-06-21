package com.github.kpacha.jkata.potter.test;

import junit.framework.TestCase;

import com.github.kpacha.jkata.potter.Potter;

public class PotterTest extends TestCase {

    public void testEmptyOrder() {
	assertEquals(0.0, Potter.priceFor(0));
    }

    public void testSingleBookOrder() {
	assertEquals(8.0, Potter.priceFor(1));
    }

    public void testTwoBookOrder() {
	assertEquals(8 * 2 * 0.95, Potter.priceFor(2));
    }

    public void testThreeBookOrder() {
	assertEquals(8 * 3 * 0.90, Potter.priceFor(3));
    }

    public void testFourBookOrder() {
	assertEquals(8 * 4 * 0.80, Potter.priceFor(4));
    }

    public void testFiveBookOrder() {
	assertEquals(8 * 5 * 0.75, Potter.priceFor(5));
    }
}
