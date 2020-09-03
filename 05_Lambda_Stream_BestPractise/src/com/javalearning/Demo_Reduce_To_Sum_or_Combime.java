package com.javalearning;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Demo_Reduce_To_Sum_or_Combime {
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1, 3, 5, 4, 7);
		
		int sum1 = list.stream().mapToInt((i) -> Integer.valueOf(i)).sum();
		System.out.println("sum1: " + sum1);
		//sum1: 20
		
		
		int sum2 = list.stream().reduce(1, (x, y) -> x + y); // 1 + (list), 1 is start value, then plus each value in list
		System.out.println("sum2: " + sum2);
		//sum2: 21
		
		
		String[] strings = {"a", "b", "c", "d", "e"};		
		Optional<String> text = Arrays.stream(strings).reduce((word1, word2) -> word1 + ", " + word2); //join string
		
		if (text.isPresent()){
			System.out.println(text.get());
			//a, b, c, d, e
		}
				
	}
	
}
