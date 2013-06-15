package com.github.kpacha.jkata.primeFactors.test;

import java.util.List;

import junit.framework.TestCase;

public class PrimeFactorsTest extends TestCase {
    public void testOne() throws Exception {
	assertEquals(list(), PrimeFactors.generate(1));
    }

    private List<Integer> list() {
	return null;
    }
}
