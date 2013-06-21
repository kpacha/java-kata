package com.github.kpacha.jkata.anagram.test;

import junit.framework.TestCase;

import com.github.kpacha.jkata.anagram.Anagram;

public class AnagramTest extends TestCase {

    public void testSingleLetterWord() {
	assertEquals("I", Anagram.generate("I"));
    }

    public void testTwoLetterWord() {
	assertEquals(buildSet("on", "no"), Anagram.generate("no"));
    }
}
