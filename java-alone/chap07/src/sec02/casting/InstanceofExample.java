package sec02.casting;

import sec02.casting.Child;

public class InstanceofExample {
	// 부모클래스를 자식 클래스 강제형변환을 안전하게 리턴하는 메소드
	public static Child method1(Parent parent) {
		Child child = null;
		
		if(parent instanceof Child) {
			child = (Child) parent; // 강제 형변환
			System.out.println("메소드1 자식으로 변환 성공");
		} else {
			System.out.println("메소드1 자식으로 변환 안됨");
		}
		return child;
	}
		public static void method2(Parent parent) {
			Child child = (Child) parent;
			System.out.println("메소드2 자식으로 변환 성공");
	}

	public static void main(String[] args) {
		Parent parentA = new Child();
		method1(parentA);
		method2(parentA);
		

		Parent parentB = new Child();
		method1(parentB);
		method2(parentB);
		
		//method1(new Child());	// Instance of true
		//method1(new Parent());	//false
	
	}

}
