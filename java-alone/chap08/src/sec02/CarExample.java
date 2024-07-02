package sec02;

public class CarExample {

	public static void main(String[] args) {
		Car myCar = new Car();
		
		myCar.run(); // 한국타이어가 굴러 갑니당. 4번
		
		myCar.fontLeftTire = new KumhoTire();
		myCar.fontRightTire = new KumhoTire();
		
		myCar.run(); //한국타이어가 굴러갑니당 2번, 금호 타이어가 굴러갑니당. 2번
		
	}

}
