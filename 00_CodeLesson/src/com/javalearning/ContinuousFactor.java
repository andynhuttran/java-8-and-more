package com.javalearning;

/**
 * An integer is defined to be “continuous factored” 
 * if it can be expressed as the product of two or more continuous integers greater than
 *
 *Examples of “continuous factored” integers are:
 * 	6 = 2 * 3.
	60 = 3 * 4 * 5
	120 = 4 * 5 * 6
	90 = 9*10
	Examples of integers that are NOT “continuous factored” are: 99 = 9*11, 121=11*11, 2=2, 13=13
 * 
 */

public class ContinuousFactor {
	
	public static void main(String[] args) {
		boolean b = doContinuousFactor(90);
		System.out.println(b);
	}
	
	public static boolean doContinuousFactor(int n) {		
		for (int i = 2; i < n/2; ++i){
			if (n%i == 0){
				boolean result = div(n/i, i+1);
				if (result == true) return true;
			}
		}		
		return false;
	}
	
	
	public static boolean div(int n, int i){		
		if (n%i != 0) return false;
		if (n == i) return true;		
		return div(n/i, i+1);	
	}
	
	
}
