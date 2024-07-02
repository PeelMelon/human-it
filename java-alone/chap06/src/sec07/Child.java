package sec07;

public class Child extends Parent {
	void method3() {
		System.out.println("Child의 method3");
	}
	void method2() {
		System.out.println("Child의 method2");
		super.method2(); // 부모클래스의 method2 메소드 호출
	} //먼저 만들어놨기 때문에 상속보다 우선순위

	
}
