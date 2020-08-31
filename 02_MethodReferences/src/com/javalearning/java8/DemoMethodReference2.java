package com.javalearning.java8;

import java.util.Arrays;
import java.util.List;

public class DemoMethodReference2 {
	
	

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Java", "C++", "PHP", "C#", "Javascript");
				
		list.forEach(System.out::println);
		//Java
		//C++
		//PHP
		//C#
		//Javascript
		
		
		System.out.println();
		list.forEach(System.out::print);
		//JavaC++PHPC#Javascript
		
		
		//sort and print by an anonymous functions
		System.out.println();
		list.sort(String::compareToIgnoreCase);		
		list.forEach( (item) -> {			
			String upperCase = item.toUpperCase();			
			System.out.print(upperCase + " ");
		});
		//C# C++ Java Javascript PHP
		
		
	}

}
