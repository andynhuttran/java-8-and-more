package com.javalearning;

interface GenericDAO<T> {
	boolean delete(T t);
	void insert(T t);
}

class GenericInteger implements GenericDAO<Integer> {
	@Override
	public boolean delete(Integer t) {
		if (t < 0){
			System.out.println("Can not delete " + t);
			return false;
		}
		System.out.println(t + " is deleted");
		return true;
	}

	@Override
	public void insert(Integer t) {
		System.out.println("Inserting..." + t);
		System.out.println("Done to insert: " + t);
	}
}

public class SimpleGeneric03 {
	public static void main(String[] args) {		
		GenericInteger genericInteger = new GenericInteger();		
		genericInteger.delete(5);
		//5 is deleted
		
		genericInteger.insert(4);
		//Inserting...4
		//Done to insert: 4
				
		genericInteger.delete(-1);
		//Can not delete -1
	}
	
}

















