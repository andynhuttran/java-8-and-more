package com.javalearning.java8;

@FunctionalInterface
interface Executor {	
	int execute(int a, int b);	
}

class Util {
	
	public static int Add(int a, int b){
		return a+b;
	}
	
	public int Minus(int a, int b){
		return a-b;
	}
	
}

public class DemoMethodReference1 {
	
	int doAction(int a, int b, Executor action){
		return action.execute(a, b);		
	}
	
	public int getDouble(int a){
		return 2*a;
	}

	public static void main(String[] args) {
		DemoMethodReference1 demoMethodReference = new DemoMethodReference1();
		
		//method is static, Class::method
		int result1 = demoMethodReference.doAction(10, 7, Util::Add); //10 + 7 = 17
		System.out.println("result1: " + result1);
		
		//method is function, install_obj::method
		Util util = new Util();
		int result2 = demoMethodReference.doAction(10, 7, util::Minus); //10 - 7 = 3
		System.out.println("result2: " + result2);
		
		
		//define an anonymous functions
		int result3 = demoMethodReference.doAction(10, 7, 
				//define a function with two parameter and return a integer value
				(a, b) -> {
					int c = demoMethodReference.getDouble(a);
					return c + b;
				}
		); //10*2 + 7 = 27
		System.out.println("result3: " + result3);
		
	}

}
