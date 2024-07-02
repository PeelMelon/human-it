package sec02;

public class Car {
	Tire fontLeftTire = new HankookTire();  // 인터페이스 자동형변환
	Tire fontRightTire = new HankookTire(); // 킹터페이스 자동형변환
	Tire backLeftTire = new HankookTire();
	Tire backRightTire = new HankookTire();
	
	void run() {
		fontLeftTire.roll();
		fontRightTire.roll();
		backLeftTire.roll();
		backRightTire.roll();
	}
	
}
