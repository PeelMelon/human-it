package com.Bochung1;

// 제네릭 타입을 상속받는 예제
public class ChildProduct <T, M, C> extends Product<T, M> {
	private C company;

	public C getCompany() {
		return company;
	}

	public void setCompany(C company) {
		this.company = company;
	}
	
}
