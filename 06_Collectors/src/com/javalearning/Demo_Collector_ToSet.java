package com.javalearning;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Demo_Collector_ToSet {
	public static void main(String[] args) {
		
		int[] array = {1, 3, 7, 4, 9, 2, 2};
		
		Set<Integer> list = Arrays.stream(array)
								.boxed() //wrap int to Integer
								.filter(x -> x%2 == 0) //filter odd number
								.collect(Collectors.toSet()); //collect items from stream to set
		
		
		list.forEach(System.out::println);
		//2 4
	}
}
