package com.javalearning.java8;

import java.util.stream.IntStream;

/**
 * print 10 first prime number from 0
 * @author cole.nhut.tran
 *
 */

public class Demo_Stream_PrimeNumber {
	
	public static void main(String[] args) {
		
		//print 10 first prime number from 0
		IntStream.iterate(0, n -> n+1).filter(Demo_Stream_PrimeNumber::isPrime).limit(10).forEach(i -> System.out.print(i + " "));
		//2 3 5 7 11 13 17 19 23 29 
		
		
		//print all prime numbers from 0 to 100
		System.out.println();
		IntStream.rangeClosed(0, 100).filter(Demo_Stream_PrimeNumber::isPrime).forEach(i -> System.out.print(i + " "));
		//2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97 
		
	}
	
	public static boolean isPrime(int n){
		if (n < 2) return false;
		if (n == 2) return true;
		
		
		return IntStream.rangeClosed(2, (int)Math.sqrt(n)).noneMatch(i -> {
													return n%i == 0;
												});
	}
}
