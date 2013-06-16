package com.github.kpacha.jkata.romanNumerals;

public class RomanNumerals {

    public static String convert(int number) {
	String roman = "";
	while (number >= 5) {
	    roman += "V";
	    number -= 5;
	}
	while (number == 4) {
	    roman += "IV";
	    number -= 4;
	}
	while (number >= 1) {
	    roman += "I";
	    number -= 1;
	}
	return roman;
    }
}
