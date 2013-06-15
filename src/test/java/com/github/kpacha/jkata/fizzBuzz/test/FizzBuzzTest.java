package com.github.kpacha.jkata.fizzBuzz.test;

import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.github.kpacha.jkata.fizzBuzz.FizzBuzz;

@RunWith(Parameterized.class)
public class FizzBuzzTest extends TestCase {

    private List<Object> list;
    private int total;

    public FizzBuzzTest(int total, List<Object> list) {
	this.total = total;
	this.list = list;
    }

    @Test
    public void testGenerator() {
	assertEquals(list, FizzBuzz.generate(total));
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
	final Object[][] objects = { { 1, Arrays.asList(1) },
		{ 2, Arrays.asList(1, 2) }, { 3, Arrays.asList(1, 2, "Fizz") } };
	return Arrays.asList(objects);
    }
}
