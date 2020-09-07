package com.javalearning;

class MyUtil {
	public static <T> int find(T[] arr, T item){
		
		int idx = 0;
		for (T t : arr){
			if (t.equals(item)){
				return idx; 
			}
			idx++;
		}
		
		return -1;
	}
}

public class MethodGeneric {
	public static void main(String[] args) {
		Integer[] arr = new Integer[3];
		arr[0] = 0; 
		arr[1] = 2; 
		arr[2] = 3;
		
		int idx = MyUtil.find(arr, 2);
		
		System.out.println("idx: " + idx);
		//idx: 1
	}
}
