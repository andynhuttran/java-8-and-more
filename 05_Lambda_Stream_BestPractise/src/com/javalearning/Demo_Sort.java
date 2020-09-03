package com.javalearning;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Demo_Sort {

	public static void main(String[] args) {
		
		List<String> list = buildString(5);
		
		
		Comparator<String> comparator = (str1, str2) -> {
			return str1.compareTo(str2);
		};
		//use existed comparator, and reverse result
		list.stream().sorted(comparator.reversed()).collect(Collectors.toList());
		
		
		//use lambda
		list.stream().sorted((str1, str2) -> str1.compareTo(str2)).collect(Collectors.toList());
		
	}
	
	public static List<String> buildString(int n){
		
		List<String> list = new ArrayList<String>();
		
		Random random = new Random();
		
		for (int i = 0; i < n; ++i){
			String str = String.valueOf(random.nextInt());
			list.add(str);
		}
		
		return list;
	}

}
