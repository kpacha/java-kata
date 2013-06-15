package com.github.kpacha.jkata.primeFactors.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.github.kpacha.jkata.primeFactors.PrimeFactors;

public class PrimeFactorsTest extends TestCase {
    public void testOne() throws Exception {
	assertEquals(list(), PrimeFactors.generate(1));
    }

    public void testTwo() throws Exception {
	assertEquals(list(2), PrimeFactors.generate(2));
    }

    public void testThree() throws Exception {
	assertEquals(list(3), PrimeFactors.generate(3));
    }

    public void testFour() throws Exception {
	assertEquals(list(2, 2), PrimeFactors.generate(4));
    }

    public void testFive() throws Exception {
	assertEquals(list(5), PrimeFactors.generate(5));
    }

    public void testSix() throws Exception {
	assertEquals(list(2, 3), PrimeFactors.generate(6));
    }

    public void testSeven() throws Exception {
	assertEquals(list(7), PrimeFactors.generate(7));
    }

    public void testEight() throws Exception {
	assertEquals(list(2, 2, 2), PrimeFactors.generate(8));
    }

    public void testNine() throws Exception {
	assertEquals(list(3, 3), PrimeFactors.generate(9));
    }

    private List<Integer> list(int... ints) {
	List<Integer> list = new ArrayList<Integer>();
	for (int i : ints) {
	    list.add(i);
	}
	return list;
    }
}
