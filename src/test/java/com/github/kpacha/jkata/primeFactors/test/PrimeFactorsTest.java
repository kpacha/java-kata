package com.github.kpacha.jkata.primeFactors.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.github.kpacha.jkata.primeFactors.PrimeFactors;

@RunWith(Parameterized.class)
public class PrimeFactorsTest extends TestCase {
    private int number;
    private List<Integer> factors;

    public PrimeFactorsTest(int number, List<Integer> factors) {
	this.number = number;
	this.factors = factors;
    }

    @Test
    public void testGenerator() throws Exception {
	assertEquals(factors, PrimeFactors.generate(number));
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
	final Object[][] objects = { { 1, new ArrayList() },
		{ 2, Arrays.asList(2) }, { 3, Arrays.asList(3) },
		{ 4, Arrays.asList(2, 2) }, { 5, Arrays.asList(5) },
		{ 6, Arrays.asList(2, 3) }, { 7, Arrays.asList(7) },
		{ 8, Arrays.asList(2, 2, 2) }, { 9, Arrays.asList(3, 3) },
		{ 10, Arrays.asList(2, 5) }, { 11, Arrays.asList(11) },
		{ 12, Arrays.asList(2, 2, 3) }, { 13, Arrays.asList(13) },
		{ 14, Arrays.asList(2, 7) }, { 15, Arrays.asList(3, 5) },
		{ 16, Arrays.asList(2, 2, 2, 2) }, { 17, Arrays.asList(17) },
		{ 18, Arrays.asList(2, 3, 3) }, { 19, Arrays.asList(19) },
		{ 20, Arrays.asList(2, 2, 5) } };
	return Arrays.asList(objects);
    }
}
