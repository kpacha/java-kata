package com.github.kpacha.jkata.romanNumerals.test;

import java.util.Arrays;
import java.util.List;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class RomanNumeralsTest {

    private String result;
    private int number;

    public RomanNumeralsTest(int number, String result) {
	this.result = result;
	this.number = number;
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
	final Object[][] objects = { { 1, "I" } };
	return Arrays.asList(objects);
    }
}
