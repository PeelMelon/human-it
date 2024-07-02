package sec02;

public class ChildExample {

	public static void main(String[] args) {
		Child child =  new Child();
		
		Parent parent = child; // 클래스 자동변환;
		parent.method1();
		parent.method2(); // Parent 의 method2가 아니라 Child 의 method2가 실행 된다.
		//parent.method3();

	}

}
