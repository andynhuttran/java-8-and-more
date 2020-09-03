package com.javalearning;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo_Collector_ToList {
	public static void main(String[] args) {
		
		int[] array = {1, 3, 7, 4, 9, 2, 2};
		
		List<Integer> list = Arrays.stream(array)
								.boxed() //wrap int to Integer
								.filter(x -> x%2 == 0) //filter odd number
								.collect(Collectors.toList()); //collect items from stream to list
		
		
		list.forEach(System.out::println);
		//4 2 2
	}
}
