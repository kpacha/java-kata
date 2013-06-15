package com.github.kpacha.jkata.primeFactors;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

    public static List<Integer> generate(int number) {
	List<Integer> primes = new ArrayList<Integer>();
	int factorCandidate = 2;
	while (number > 1) {
	    for (; number % factorCandidate == 0; number /= factorCandidate) {
		primes.add(factorCandidate);
	    }
	    factorCandidate++;
	}
	return primes;
    }
}
