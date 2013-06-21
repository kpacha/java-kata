package com.github.kpacha.jkata.anagram;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Anagram {

    public static Set<String> generate(String source) {
	Set<String> result = new HashSet<String>();
	List<Character> chars = new ArrayList<Character>();
	for (char c : source.toCharArray()) {
	    chars.add(c);
	}

	if (chars.size() == 3) {
	    for (String part : Anagram.generate(source.substring(1))) {
		result.add(source.substring(0, 1) + part);
	    }
	    for (String part : Anagram.generate(source.substring(0, 1)
		    + source.substring(2))) {
		result.add(source.substring(1, 2) + part);
	    }
	    for (String part : Anagram.generate(source.substring(0, 2))) {
		result.add(source.substring(2) + part);
	    }
	}
	if (chars.size() == 2) {
	    for (String part : Anagram.generate(source.substring(0, 1))) {
		result.add(source.substring(1) + part);
	    }
	    for (String part : Anagram.generate(source.substring(1))) {
		result.add(source.substring(0, 1) + part);
	    }
	}
	if (chars.size() == 1) {
	    result.add(source);
	}
	return result;
    }
}
