package com.javalearning.java8;

public class ImplementBothInterface implements Interface1, Interface2 {
	
	boolean useInterface1 = false;
	
	public ImplementBothInterface(boolean useInterface1){
		this.useInterface1 = useInterface1;
	}
	
	@Override
	public void implementInterface2() {
		doPrivateTaskFromInterface1("doPrivateTaskFromInterface1 is called from implementInterface2 in ImplementBothInterface");
	}

	@Override
	public void implementInterface1() {
		doPrivateTaskFromInterface1("doPrivateTaskFromInterface1 is called from implementInterface1 in ImplementBothInterface");
	}

	@Override
	public String doSomething() {		
		if (this.useInterface1){
			return Interface1.super.doSomething(); //use default method from Interface1
		}
		else {
			return Interface2.super.doSomething(); //use default method from Interface2
		}
	}
	
	
	public void functionWillCallStaticFunctionFromInterface(int number){
		boolean result = Interface2.isPositiveNumber(number);
		
		if (result){
			System.out.println(number + " is a positive number");
		}
		else {
			System.out.println(number + " is NOT a positive number");
		}
				
	}
	
	
	public static void main(String[] args) {
		
		ImplementBothInterface implementBothInterface = new ImplementBothInterface(true);
		
		implementBothInterface.doSomething();
		//Message from doSomething in Interface1
		
		
		implementBothInterface.implementInterface1(); //doPrivateTaskFromInterface1 is called from implementInterface1 in ImplementBothInterface
		implementBothInterface.implementInterface2(); //doPrivateTaskFromInterface1 is called from implementInterface2 in ImplementBothInterface
		
		
		implementBothInterface.doPrivateTaskFromInterface1("doPrivateTaskFromInterface1 is called from initial ImplementBothInterface");
		//doPrivateTaskFromInterface1 is called from initial ImplementBothInterface
		
		
		implementBothInterface.functionWillCallStaticFunctionFromInterface(-5);	
		//-5 is NOT a positive number
	}

}
