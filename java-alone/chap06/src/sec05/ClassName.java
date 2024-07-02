package sec05;

public class ClassName {
	// 인스턴스 필드
	int field1;
	
	//인스턴스 메소드	
	void method1() {
	}
	
	//정적 필드
	static int feild2;
	
	//정적 메소드
	static void method2() {}
	
	static void method3() {
		// this.method1(); // 정적 메소드 안에서는 정적 필드만 사용가능 .this도 사용 불가
		// this.field1 = 10; // 오류가 나는 이유는 인스턴스 필드에 들어갔기 때문이다.
		
		ClassName obj1 = new ClassName();
		
		method2();
	}

}
