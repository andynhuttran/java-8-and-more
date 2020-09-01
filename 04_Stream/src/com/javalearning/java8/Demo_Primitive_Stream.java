package com.javalearning.java8;

import java.util.stream.IntStream;

public class Demo_Primitive_Stream {
	public static void main(String[] args) {
				
		IntStream.of(1, 5, -7).forEach(System.out::println); //1 5 -7
		System.out.println("---------");
		
		
		IntStream.of(100).forEach(System.out::println); //100
		System.out.println("---------");
		
		
		IntStream.range(0, 5).forEach(System.out::println); //0 1 2 3 4
		System.out.println("---------");
		
		
		IntStream.rangeClosed(3, 6).forEach(System.out::println); //3 4 5 6
		System.out.println("---------");
		
		
		IntStream firstStream = IntStream.of(1, 3, 5);
		IntStream secondStream = IntStream.of(2, 4, 6);
		IntStream.concat(firstStream, secondStream).forEach(System.out::println); //1 3 5 2 4 5		
		System.out.println("---------");
		
		
		IntStream.iterate(0, n -> n+1)
			.limit(10)
			.forEach(System.out::println); //0 1 2 3 4 5 6 7 8 9

	}
}
