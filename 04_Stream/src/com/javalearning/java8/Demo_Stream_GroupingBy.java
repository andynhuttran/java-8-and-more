package com.javalearning.java8;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * demo how to use group by in stream
 * @author cole.nhut.tran
 *
 */


class Product {
	String name;
	int quantity;
	float price;
	
	public Product(String name, int age, float price) {
		this.name = name;
		this.quantity = age;
		this.price = price;
	}

	public String getName() {
		return name;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public float getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return "Staff [name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
	public static List<Product> buildDataSource(){
		return Arrays.asList(
				new Product("Oil", 10, 3.0f),
				new Product("Apple", 23, 2.5f),
				new Product("Food", 8, 3.0f),
				new Product("Apple", 14, 2.5f),
				new Product("Kittle", 11, 1.5f),
				new Product("Kittle", 2, 1.5f)
				);
	}
}

public class Demo_Stream_GroupingBy {

	public static void main(String[] args) {
		List<Product> list = Product.buildDataSource();
		
		//group by name, and counting
		Map<String, Long> groupByName_Counting = list.stream().collect(
																Collectors.groupingBy(
																		(p) -> p.getName(), 
																		Collectors.counting())
																);		
		System.out.println(groupByName_Counting);
		//{Apple=2, Oil=1, Kittle=2, Food=1}
		
		
		
		//group by name, and sum of quantity
		Map<String, Integer> groupByName_quanlity = list.stream().collect(
														Collectors.groupingBy(
															p -> "group-" + p.getName(),															
															Collectors.summingInt(Product::getQuantity) 
														)
													);		
		System.out.println(groupByName_quanlity);
		//{group-Kittle=13, group-Apple=37, group-Food=8, group-Oil=10}
		
		
		
		
		//group by name, and product
		Map<String, List<Product>> groupByName_product = list.stream().collect(
														Collectors.groupingBy(
															p -> "group-" + p.getName()
														)
													);		
		System.out.println(groupByName_product);
		
		/*
		{
			group-Kittle=[	Staff [name=Kittle, quantity=11, price=1.5], 
							Staff [name=Kittle, quantity=2, price=1.5]
						], 

			group-Apple=[	Staff [name=Apple, quantity=23, price=2.5], 
							Staff [name=Apple, quantity=14, price=2.5]
						], 
					
			group-Food=[	Staff [name=Food, quantity=8, price=3.0]
						], 
		
			group-Oil=[		Staff [name=Oil, quantity=10, price=3.0]]
				
		}
		*/
		
		
		
		//group by price (Float), and product name
		Map<Float, Set<String>> groupByPrice_name = list.stream().collect(
														Collectors.groupingBy(
															p -> p.getPrice(),															
															Collectors.mapping(
																	p -> p.getName(), 
																	Collectors.toSet()
																	)
														)
													);		
		System.out.println(groupByPrice_name);
		//{1.5=[Kittle], 2.5=[Apple], 3.0=[Oil, Food]}
	}

}















