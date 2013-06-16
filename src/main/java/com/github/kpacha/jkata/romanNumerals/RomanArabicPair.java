package com.github.kpacha.jkata.romanNumerals;

public class RomanArabicPair {

    private String roman;
    private int arabic;

    public RomanArabicPair(String roman, int arabic) {
	this.roman = roman;
	this.arabic = arabic;
    }

    /**
     * @return the roman
     */
    public String getRoman() {
	return roman;
    }

    /**
     * @return the arabic
     */
    public int getArabic() {
	return arabic;
    }

}
