package com.javalearning;

import java.util.ArrayList;
import java.util.List;

class KeyValuePair<K, V> {	
	K key;
	V value;
	
	public KeyValuePair(K key, V value){
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
}

public class SimpleGeneric01 {
	public static void main(String[] args) {
		
		String key = "abc";
		List<Integer> value = new ArrayList<>();
		value.add(2);
		value.add(3);
		
		KeyValuePair<String, List<Integer>> keyValuePair = new KeyValuePair<>(key, value);
		
		System.out.println("Key: " + keyValuePair.getKey());
		System.out.println("Value: " + keyValuePair.getValue());
		//Key: abc
		//Value: [2, 3]
	}
}
