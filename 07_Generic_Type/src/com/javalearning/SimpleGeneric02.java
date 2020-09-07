package com.javalearning;


class KeyValueObject<K, V> {	
	K key;
	V value;
	
	public KeyValueObject(K key, V value){
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

class KeyValueExtend01<V> extends KeyValueObject<String, V> {
	
	public KeyValueExtend01(String key, V value) {
		super(key, value);
	}
	
	public V doSomething1(){
		if (this.getKey().length() > 3){
			return this.getValue();
		}		
		return null;
	}	
}


class KeyValueExtend02<T> extends KeyValueObject<String, Integer> {
	private T t;
	public KeyValueExtend02(String str, T t) {
		super(str, 5);
		this.t = t;
	}
	
	public T doSomething2(){
		if (this.getKey().length() > 3){
			return this.t;
		}
		return null;
	}
}

class KeyValueExtend03<T, U> extends KeyValueObject<String, Integer> {
	private T t;
	private U u;
	
	public KeyValueExtend03(T t, U u) {
		super(t.toString(), 5);
		this.t = t;
		this.u = u;
	}
	
	public Object doSomething3(){
		if (this.getKey().length() > 3){
			return this.t;
		}
		return u;
	}
}

public class SimpleGeneric02 {
	public static void main(String[] args) {
		KeyValueExtend01<Boolean> keyValueExtend01 = new KeyValueExtend01<>("Leu leu", false);		
		Boolean doSomething1 = keyValueExtend01.doSomething1();
		System.out.println("doSomething1: " + doSomething1);
		//doSomething1: false
		
		
		KeyValueExtend02<Float> keyValueExtend02 = new KeyValueExtend02<>("Key", 5.5f);
		Float doSomething2 = keyValueExtend02.doSomething2();
		System.out.println("doSomething2: " + doSomething2);
		//doSomething2: null
		
		KeyValueExtend03<Double, Float> keyValueExtend03 = new KeyValueExtend03<>(2.2, 3.3f);
		Object doSomething3 = keyValueExtend03.doSomething3();
		System.out.println("doSomething3: " + doSomething3);
		//doSomething3: 3.3
	}
}











