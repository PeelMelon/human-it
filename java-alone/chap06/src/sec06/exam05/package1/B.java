package sec06.exam05.package1;

public class B {
	public B() {
		A a= new A();
		a.field1 = 1;
		a.field2 = 1;
		// a.field3 = 1; // error
		
		a.method1();
		a.method2();
		// a.method3(); // 접근제한
	}
}
