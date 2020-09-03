package com.javalearning.java8;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * convert list Developer to Map
 * @author cole.nhut.tran
 *
 */

class Developer {
	String name;
	int age;
	BigDecimal salary;
	
	public Developer(String name, int age, BigDecimal salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public BigDecimal getSalary() {
		return salary;
	}
	
	@Override
	public String toString() {
		return "Developer [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
	
	public static List<Developer> buildDataSource(){
		return Arrays.asList(
				new Developer("Cole", 28, BigDecimal.valueOf(200)),
				new Developer("Alex", 26, BigDecimal.valueOf(100)),
				new Developer("Alex", 25, BigDecimal.valueOf(200)),
				new Developer("Peter", 32, BigDecimal.valueOf(800)),
				new Developer("Andy", 32, BigDecimal.valueOf(750)),
				new Developer("Alex", 29, BigDecimal.valueOf(900))
				);
	}
}


public class Demo_Stream_List_To_Map {
	
	public static void main(String[] args) {
		
		List<Developer> list = Developer.buildDataSource();
		
		Map<String, Developer> map = list.stream()							
										.filter(dev -> {
											return dev.getAge() < 30;
										}) //ignore devs which are older or equal 30										
										.collect(
												Collectors
													.toMap(dev -> dev.getName(), dev -> dev, //key = name, value = dev 
														
														//handle duplicate key
														(Developer oldDev, Developer newDev) -> {
															if (oldDev.getAge() >= newDev.getAge()){
																return oldDev;
															}
															else return newDev;
														}, //choice which Dev if key is duplicated, choice new one or old one depends on age
															
														LinkedHashMap::new //use LinkedHashMap or HashMap, it's up to you, default is HashMap
													)												
												);
		
		//print them out
		map.forEach((k, v) -> {
			System.out.println(k + " - " + v);
		});
		
	}
}















