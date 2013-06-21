package com.github.kpacha.jkata.anagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Anagram {

    private static Map<String, Set<String>> processedAnagrams = new HashMap<String, Set<String>>();

    public static Set<String> generate(String source) {
	Set<String> result = processedAnagrams.get(source);
	if (result == null) {
	    result = generateAnagrams(source);
	}
	return result;
    }

    private static Set<String> generateAnagrams(String source) {
	Set<String> result;
	if (source.length() > 2) {
	    result = generateRecurrently(source);
	} else {
	    result = generateDirectly(source);
	}
	processedAnagrams.put(source, result);
	return result;
    }

    private static Set<String> generateDirectly(String source) {
	Set<String> result = new HashSet<String>();
	if (source.length() == 2) {
	    result.add(source.substring(1) + source.substring(0, 1));
	}
	result.add(source);
	return result;
    }

    private static Set<String> generateRecurrently(String source) {
	List<Character> chars = getAsCharacterList(source);
	Set<String> result = new HashSet<String>();
	for (int currentChar = 0; currentChar < chars.size(); currentChar++) {
	    Character character = chars.get(currentChar);
	    for (String part : Anagram.generate(new String(getCharsToMix(chars,
		    character)))) {
		result.add(character + part);
	    }
	}
	return result;
    }

    private static char[] getCharsToMix(List<Character> chars,
	    Character character) {
	List<Character> characters = new ArrayList<Character>(chars);
	characters.remove(character);
	char[] charArrayToMix = new char[characters.size()];
	for (int currentChar = 0; currentChar < characters.size(); currentChar++) {
	    charArrayToMix[currentChar] = characters.get(currentChar);
	}
	return charArrayToMix;
    }

    private static List<Character> getAsCharacterList(String source) {
	List<Character> chars = new ArrayList<Character>();
	for (char c : source.toCharArray()) {
	    chars.add(c);
	}
	return chars;
    }

}
