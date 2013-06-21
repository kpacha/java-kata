package com.github.kpacha.jkata.anagram.test;

import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

import com.github.kpacha.jkata.anagram.Anagram;

public class AnagramTest extends TestCase {

    public void testSingleLetterWord() {
	assertEquals(buildSet("I"), Anagram.generate("I"));
    }

    public void testTwoLetterWord() {
	assertEquals(buildSet("on", "no"), Anagram.generate("no"));
    }

    public void testThreeLetterWord() {
	assertEquals(buildSet("abc", "acb", "bac", "bca", "cab", "cba"),
		Anagram.generate("abc"));
    }

    public void testFourLetterWord() {
	assertEquals(
		buildSet("abcd", "abdc", "acbd", "acdb", "adbc", "adcb",
			"bacd", "badc", "bcad", "bcda", "bdac", "bdca", "cabd",
			"cadb", "cbad", "cbda", "cdab", "cdba", "dabc", "dacb",
			"dbac", "dbca", "dcab", "dcba"),
		Anagram.generate("abcd"));
    }

    private Set<String> buildSet(String... words) {
	Set<String> result = new HashSet<String>();
	for (String word : words) {
	    result.add(word);
	}
	return result;
    }

}
