package com.javalearning;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Person {
	String firstName;
	String lastName;
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "[" + firstName + ", " + lastName + "]";
	}
	
}

public class Demo_Collectors_groupingBy {
	
	public static void main(String[] args) {
		String[] array = {"Andy", "X", "", "David", "Lamdpard", "Terry", null, "Harry", "Harry", "X"};
		
		Map<Integer, List<Person>> map = Stream.of(array)
											.filter(s -> s != null && s.length() > 0)
											.collect(
												Collectors.groupingBy(
													s -> s.length(), //key
													Collectors.mapping(s -> {
															String fName = s + "__c__" + s.length();
															return new Person(fName, s);
														}, 
														Collectors.toList()
													) //custom value, convert from String to Person object
												)
											);
		
		map.forEach((k, v) -> System.out.println(k + " # " + v));
		/*
		 	1 # [[X__c__1, X], [X__c__1, X]]
			4 # [[Andy__c__4, Andy]]
			5 # [[David__c__5, David], [Terry__c__5, Terry], [Harry__c__5, Harry], [Harry__c__5, Harry]]
			8 # [[Lamdpard__c__8, Lamdpard]]
		 */
	}
}
