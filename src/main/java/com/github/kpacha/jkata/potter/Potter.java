package com.github.kpacha.jkata.potter;

public class Potter {

    public static double priceFor(int items) {
	return 8 * items * getDiscountFor(items);
    }

    private static double getDiscountFor(int items) {
	if (items == 3)
	    return 0.9;
	if (items == 2)
	    return 0.95;
	return 1.0;
    }
}
