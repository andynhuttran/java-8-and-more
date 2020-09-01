package com.javalearning.java8;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * compare time between sequence stream and parallel stream
 * @author cole.nhut.tran
 *
 */

public class Demo_Stream_Parallel {

	public static void main(String[] args) {
		List<String> list = createDummyData();
		
		sortBySequenceStream(list);
		//Sequence Stream sort took: 711 ms
		
		
		sortByParallelStream(list);
		//Parallel Stream sort took: 269 ms
	}
	
	public static void sortBySequenceStream(List<String> list){
		long startTime = System.nanoTime();
		 
        long count = list.stream().sorted().count();
        System.out.println(count);
 
        long endTime = System.nanoTime();
 
        long millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println(String.format("Sequence Stream sort took: %d ms", millis));
	}
	
	
	public static void sortByParallelStream(List<String> list){
		long startTime = System.nanoTime();
		 
        long count = list.parallelStream().sorted().count();
        System.out.println(count);
 
        long endTime = System.nanoTime();
 
        long millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println(String.format("Parallel Stream sort took: %d ms", millis));
	}
	
	
	public static List<String> createDummyData() {
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
        return values;
    }

}
