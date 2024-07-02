package com.Bochung1;

public class Container <E, A> {
	private E key;
	private A value;
	
	public void set(E key, A value) {
		this.key = key;
		this.value = value;
	}
	
	public E get() {
		return key;
	}
	
	public E getKey() {
		return key;
	}
	
	public A getValue() {
		return value;
	}
}
