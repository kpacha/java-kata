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
		{ 4, "IV" }, { 5, "V" }, { 6, "VI" }, { 7, "VII" },
		{ 8, "VIII" }, { 9, "IX" }, { 10, "X" }, { 14, "XIV" },
		{ 19, "XIX" }, { 21, "XXI" }, { 40, "XL" }, { 50, "L" },
		{ 59, "LIX" }, { 66, "LXVI" }, { 80, "LXXX" }, { 90, "XC" } };
	return Arrays.asList(objects);
    }
}
