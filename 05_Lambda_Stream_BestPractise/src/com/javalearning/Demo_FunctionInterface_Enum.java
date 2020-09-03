package com.javalearning;

import java.util.function.DoubleBinaryOperator;

enum Operator {
	
	PLUS("+", (x, y) -> {
		return x + y;
	}),	
	
	MINUS("-", (x, y) -> x - y ), //shortest
	
	TIMES("*", (double x, double y) -> x*y),
	
	DIVIDE("/", (double x, double y) -> { //longest
		if (y == 0) return 0;
		else return x/y;
	});	
	
	private String symbol;
	private DoubleBinaryOperator calulator;
	
	Operator(String symbol, DoubleBinaryOperator calulator){
		this.symbol = symbol;
		this.calulator = calulator;
	}
	
	@Override
	public String toString() {
		return this.symbol;
	}
	
	public double apply(double x, double y){
		return calulator.applyAsDouble(x, y);
	}
}


public class Demo_FunctionInterface_Enum {
	
	public static void main(String[] args) {
		
		double result = Operator.PLUS.apply(1.5, 3.5);		
		System.out.println("result: " + result);
		
	}
}













