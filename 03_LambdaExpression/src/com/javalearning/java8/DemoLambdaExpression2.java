package com.javalearning.java8;

/**
 *  scope to access variable
 */

@FunctionalInterface
interface Converter<F, T> {
	T convert(F from);
}


public class DemoLambdaExpression2 {
	
	double fieldFromClass = 5.0f;
	
	public void demo1(){		
		Converter<String, Integer> string2Integer = (String from) -> {
			int to = Integer.valueOf(from);
			return to;
		};
		
		int result = string2Integer.convert("123");
		System.out.println("demo1: " + result); //demo1: 123
	}
	
	
	public void demo2(){		
		String helloText = "Hello ";
		
		Converter<String, String> string2Integer = (String from) -> {
			String to = helloText + from;
			return to;
		};
		
		String result = string2Integer.convert("123");
		System.out.println("demo2: " + result); //demo2: Hello 123
	}
	
	
	public void demo3(){		
		double factor = 2.0f;
		
		Converter<Integer, Double> string2Integer = (Integer from) -> {
			double to = from*factor;
			return to;
		};
		
		double result = string2Integer.convert(123);
		System.out.println("demo3: " + result); //demo3: 246.0
		
		//factor in lambda express will be error if remove comment factor = 2.1f below
		//factor = 2.1f;		
	}
	
	
	public void demo4(){		

		Converter<Integer, Double> string2Integer = (Integer from) -> {
			double to = from*this.fieldFromClass;
			return to;
		};
		
		double result = string2Integer.convert(123);
		System.out.println("demo4: " + result); //demo3: 246.0
		
		//can access and modify fields from class after using it in lambda expression
		this.fieldFromClass = 0.0;
	}
	
	
	public static void main(String[] args) {
		DemoLambdaExpression2 demoLambdaExpression = new DemoLambdaExpression2();
		
		demoLambdaExpression.demo1();
		
		demoLambdaExpression.demo2();
		
		demoLambdaExpression.demo3();		
		
		demoLambdaExpression.demo4(); //demo4: 615.0, because this.fieldFromClass = 5.0 at the first
		demoLambdaExpression.demo4(); //demo4:   0.0, because this.fieldFromClass has been assigned to 0.0 
	}
}
