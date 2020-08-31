package com.javalearning.java8;

/**
 * Basic 
 */

@FunctionalInterface
interface Calculable {
	int calculate(int a, int b);
}


public class DemoLambdaExpression1 {
	public static void main(String[] args) {
		
		//without data type
		Calculable addition = (a, b) -> {
			return a+b;
		};
		addition.calculate(10, 2); //10 + 2 = 12
		
		
		//with data type and  return
		Calculable minus = (int a, int b) -> {
			int rs = a - b;
			return rs;
		};
		minus.calculate(10, 2); //10 - 2 = 8
		
		
		//without return
		Calculable shortedStyle = (a, b) -> a*3 - b;
		shortedStyle.calculate(10, 2); //10*3 - 2 = 28
		
	}
}
