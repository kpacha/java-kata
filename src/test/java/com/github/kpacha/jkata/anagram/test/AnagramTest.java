package com.github.kpacha.jkata.anagram.test;

import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

import com.github.kpacha.jkata.anagram.Anagram;

public class AnagramTest extends TestCase {

    public void testSingleCharWord() {
	assertEquals(buildSet("I"), Anagram.generate("I"));
    }

    public void testTwoCharsWord() {
	assertEquals(buildSet("on", "no"), Anagram.generate("no"));
    }

    public void testThreeCharsWord() {
	assertEquals(buildSet("abc", "acb", "bac", "bca", "cab", "cba"),
		Anagram.generate("abc"));
    }

    public void testFourCharsWord() {
	assertEquals(
		buildSet("abcd", "abdc", "acbd", "acdb", "adbc", "adcb",
			"bacd", "badc", "bcad", "bcda", "bdac", "bdca", "cabd",
			"cadb", "cbad", "cbda", "cdab", "cdba", "dabc", "dacb",
			"dbac", "dbca", "dcab", "dcba"),
		Anagram.generate("abcd"));
    }

    public void testSixCharsWordCounter() {
	assertEquals(720, Anagram.generate("abcdef").size());
    }

    public void testEightCharsWordCounter() {
	assertEquals(40320, Anagram.generate("abcdefgh").size());
    }

    private Set<String> buildSet(String... words) {
	Set<String> result = new HashSet<String>();
	for (String word : words) {
	    result.add(word);
	}
	return result;
    }

}
