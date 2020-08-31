package com.javalearning.java8;

public interface Interface2 {
	
	//default function
	default String doSomething(){
		String msg = "Message from doSomething in Interface2";		
		System.out.println(msg);
		
		return msg;
	}
	
	void implementInterface2();
	
	
	//static function
	static boolean isPositiveNumber(int number){
		return number >= 0;
	}
}
