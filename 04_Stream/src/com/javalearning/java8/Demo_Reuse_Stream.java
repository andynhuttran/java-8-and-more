package com.javalearning.java8;

import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * by default, we can NOT reuse stream 
 *	It's better to use Supplier to handle Stream and reuse it
 */

public class Demo_Reuse_Stream {
	public static void main(String[] args) {
		
		Supplier<IntStream> supplierStream = () -> {
			return IntStream.range(0, 10);
		};
		
		supplierStream.get().filter((i) -> {
			return i%2 == 0;
		}).forEach((i) -> {
			System.out.print(i + " ");
		}); //0 2 4 6 8 
		
		
		System.out.println();
		supplierStream.get().filter((i) -> {
			return i%2 != 0;
		})
		.skip(1) //ignore first item
		.limit(3) //maximun is 3 items, it is like limit in SQL
		.forEach((i) -> {
			System.out.print(i + " ");
		}); //3 5 7 

	}
	
}
