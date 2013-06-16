package com.github.kpacha.jkata.romanNumerals.test;

import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.github.kpacha.jkata.romanNumerals.RomanNumerals;

@RunWith(Parameterized.class)
public class RomanNumeralsTest extends TestCase {

    private String result;
    private int number;

    public RomanNumeralsTest(int number, String result) {
	this.result = result;
	this.number = number;
    }

    @Test
    public void testConverter() {
	assertEquals(result, RomanNumerals.convert(number));
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
	final Object[][] objects = { { 1, "I" }, { 2, "II" }, { 3, "III" },
		{ 4, "IV" }, { 5, "V" } };
	return Arrays.asList(objects);
    }
}
