package com.javalearning.java8;

public interface Interface1 {
	
	default void doPrivateTaskFromInterface1(String msg){
		System.out.println(msg);
	}
	
	default String doSomething(){
		String msg = "Message from doSomething in Interface1";
		System.out.println(msg);		
		return msg;
	}
	
	void implementInterface1();
}
