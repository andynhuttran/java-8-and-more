package com.javalearning;

import java.util.ArrayList;
import java.util.List;


public class ListGenericType {
	public static void main(String[] args) {
		
		List<? super Number> listGeneric = new ArrayList<>();
		listGeneric.add(Integer.MAX_VALUE);
		listGeneric.add(Float.MIN_VALUE);
		listGeneric.add(Long.MAX_VALUE);
		listGeneric.add(Double.MIN_VALUE);
		
		listGeneric.forEach(System.out::println);
		
		
		List<? extends Number> listGenericExtend = new ArrayList<>();
		//listGenericExtend.add(Integer.MAX_VALUE);
		//error, can not add when using extends
		
	}
}
