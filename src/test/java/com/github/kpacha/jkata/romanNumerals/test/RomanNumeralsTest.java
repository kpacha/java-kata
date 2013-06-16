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

    private String roman;
    private int arabic;

    public RomanNumeralsTest(int arabic, String roman) {
	this.roman = roman;
	this.arabic = arabic;
    }

    @Test
    public void testConverterToRoman() {
	assertEquals(roman, RomanNumerals.convert(arabic));
    }

    @Test
    public void testConverterToArabic() {
	assertEquals(arabic, RomanNumerals.convert(roman));
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
	final Object[][] objects = { { 1, "I" }, { 2, "II" }, { 3, "III" },
		{ 4, "IV" }, { 5, "V" }, { 6, "VI" }, { 7, "VII" },
		{ 8, "VIII" }, { 9, "IX" }, { 10, "X" }, { 14, "XIV" },
		{ 19, "XIX" }, { 21, "XXI" }, { 40, "XL" }, { 50, "L" },
		{ 59, "LIX" }, { 66, "LXVI" }, { 80, "LXXX" }, { 90, "XC" },
		{ 100, "C" }, { 400, "CD" }, { 500, "D" }, { 900, "CM" },
		{ 999, "CMXCIX" }, { 1000, "M" }, { 1492, "MCDXCII" },
		{ 1990, "MCMXC" }, { 2008, "MMVIII" }, { 3498, "MMMCDXCVIII" } };
	return Arrays.asList(objects);
    }
}
