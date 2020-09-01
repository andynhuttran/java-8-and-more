package com.javalearning.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo_Stream_Basic {
	
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("Java", "C#", "Python", "Javascript");
		
		List<String> newList = list.stream()
				.filter(str -> {
					if (str.length() > 3) {
						return true;
					}
					else {
						return false;
					}
				}) //filter with a Predicate which receive a input and return boolean
				//in this case, receive a String and check its length, remove C# out
				.map( str -> {
					if (str.length() <= 4){
						return str.toUpperCase();
					}
					else {
						return str.toLowerCase();
					}
				}) //map with a Function which receive a input T (any) and return a R value (any)
				//in this case, receive a String, and return a String, upper case JAVA only
				.collect(Collectors.toList()); 
				//
		
		//print them out
		newList.forEach(str -> System.out.println(str));
		
	}
}
