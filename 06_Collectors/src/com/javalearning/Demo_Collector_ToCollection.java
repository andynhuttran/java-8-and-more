package com.javalearning;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Demo_Collector_ToCollection {
	public static void main(String[] args) {
		
		int[] array = {1, 3, 7, 4, 9, 2, 2};
		
		List<Integer> list = Arrays.stream(array)
								.boxed() //wrap int to Integer
								.filter(x -> x%2 == 0) //filter odd number
								.collect(Collectors.toCollection(LinkedList::new)); //collect items from stream to a implementation LinkedList
		
		
		list.forEach(System.out::println);
		//4 2 2
	}
}
