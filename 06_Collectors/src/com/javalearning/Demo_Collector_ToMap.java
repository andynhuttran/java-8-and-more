package com.javalearning;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo_Collector_ToMap {
	public static void main(String[] args) {
		
		String[] array = {"Andy", "X", "", "David", "Lamdpard", "Terry", null, "Harry", "Harry", "X"};
		
		Map<Integer, String> map = Arrays.stream(array)
											.filter(x -> x != null && x.length() > 0) //filter odd number
											.collect(
												Collectors.toMap(
													str -> str.length(), //key, get length of name
													str -> str, //value
													(oldValue, newValue) -> newValue, //handle duplicate, choice new one
													LinkedHashMap::new //create Map by LinkedHashMap, keep the original order, HashMap is not
												)
											);
											
		
		map.forEach((k, v) -> System.out.println(k + " - " + v));
		//4 - Andy
		//1 - X
		//5 - Harry
		//8 - Lamdpard
		
		System.out.println("|");
		Map<String, Integer> map2 = Arrays.stream(array)
				.filter(x -> x != null && x.length() > 0) //filter odd number
				.collect(
					Collectors.toMap(
						str -> str, //key, get length of name
						str -> str.length(), //value
						(oldValue, newValue) -> oldValue+newValue, //handle duplicate, double
						HashMap::new //create Map by HashMap, reorder
					)
				);
				

		map2.forEach((k, v) -> System.out.println(k + " - " + v));
		/*
		Harry - 10
		Lamdpard - 8
		Terry - 5
		David - 5
		X - 2
		Andy - 4
		*/
	}
}
