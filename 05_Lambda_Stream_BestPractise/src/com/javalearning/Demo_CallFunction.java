package com.javalearning;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Task {
	
	private int start;
	private int begin;
	
	public Task(int start, int begin){
		this.start = start;
		this.begin = begin;
	}
	
	private int times(int source, int times){
		return source*times;
	}
	
	public static int triple(int source){
		return source*3;
	}
	
	public void doTask(){		
		IntStream.range(start, begin).map((i) -> times(i, 2)) //call a local method
									.map(Task::triple) //call a static method
									.mapToObj((i) -> {
										return "text-"+i;
									}) //convert IntStream to ObjectStream
									.forEach(System.out::println); //print them out
	}
	
}

public class Demo_CallFunction {
	public static void main(String[] args) {
		Task t = new Task(0, 10);
		t.doTask();
		
		Stream<String> stream = Stream.of("abc", "xyz");
		
		
		
	}
}








