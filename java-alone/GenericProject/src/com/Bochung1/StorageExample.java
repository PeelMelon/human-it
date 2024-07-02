package com.Bochung1;

public class StorageExample <T> implements Storage<T> {
	// 필드
	private T[] array;
	
	// 생성자
	public void StorageImpl(int size) {
		this.array = (T[])new Object[size]; // 객체 배열 초기화
	}
		
	// 메소드
	@Override
	public void add(T item, int index) {
			array[index] = item;
	}

	@Override
	public T get(int index) {
		return array[index];
	}

}
