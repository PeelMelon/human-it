package sec02;

public class Example {

	public static void main(String[] args) {
		ImplementationC impl = new ImplementationC();
		
		InterfaceA ia = impl; //인터페이스A로 자동형변환
		ia.methodA();		//mplementionC 의 메소드A를 실행
		System.out.println();
		
		InterfaceB ib = impl;
		ib.methodB();
		System.out.println();
		
		InterfaceC ic = impl; // InterfaceC 로 자동형변환
		ic.methodA(); // ImplementationC 의 methodA를 실행
		ic.methodB(); // ImplementationC 의 methodB를 실행
		ic.methodC(); // ImplementationC 의 methodC를 실행
	
	}

}
